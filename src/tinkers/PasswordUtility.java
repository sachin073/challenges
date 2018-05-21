package tinkers;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class PasswordUtility {

    /**
     * @param args
     */
    private static final String ALGORITHM = "AES"; //Used in 128Bit Encryption/Decryption
    private static final String TRANSFORMATION = "AES";//Used in 128Bit Encryption/Decryption
    // AES specification - changing will break existing encrypted streams!
    private static final String CIPHER_SPEC = "AES/CBC/PKCS5Padding";
    // Key derivation specification - changing will break existing streams!
    private static final String KEYGEN_SPEC = "PBKDF2WithHmacSHA1";
    private static final int SALT_LENGTH = 16; // in bytes
    private static final int AUTH_KEY_LENGTH = 8; // in bytes
    private static final int ITERATIONS = 32768;
    // Process input/output streams in chunks - arbitrary
    private static final int BUFFER_SIZE = 1024;
    private final static int keyLength=256;
    private static final PasswordUtility object = new PasswordUtility();
    private static final Scanner sc = new Scanner(System.in);
    private static final String  keyStoreFile = "fcKeyStore.jceks";
    private static String keyStoreCredentials[]=null;
    private static String encryptedFilePath;
    private static String encryptedFileKey;



    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub



        System.out.println("------------------------------------------------------------------------");
        System.out.println("                 		 Security Portal                                ");
        System.out.println("------------------------------------------------------------------------");

        System.out.println("init process to Create new keystore ");

        object.changeStore();

        System.out.println("\n\ninit process to Create encrypted file and DB key. ");
        System.out.println("File key is use to create secretKey.document.encrypted which stores DB key which is used to encrypt Db data.");
        object.addNewKey();

        System.out.println("\n\nProcess completed .");
        System.out.println("Please copy secretKey.document.encrypted to : \"/src/WEB-INF/classes/ \" of respective build " +
                "and rest 3 files to $(JAVA_HOME)/bin/fckey/ ");



    }

    private String[] getStorePasswordAndSecurePassword(){
        String pass[]= new String[2];

        System.out.println("Enter existing Key Store Passowrd: ");
        pass[0]=sc.next();
        System.out.println("Enter existing Key Secure Passowrd: ");
        pass[1]=sc.next();
        keyStoreCredentials=pass;
        return pass;
    }

    private void changeStore() throws Exception{
        try{
            System.out.println("Please enter credential to access new keystore. ");

            System.out.println("Enter New Key Store Password : ");
            String newStorePassword=sc.next();
            System.out.println("Enter New Key Secure Password: ");
            String newSecurePassword=sc.next();
            System.out.println("Please Enter Path Where you want to create new Key Store with New Credentials(path of Directory) ");
            String outPutFilePath=sc.next();
            String inputStorePassword="tempStorePass.txt";
            object.createFileContent(inputStorePassword, newStorePassword);
            String inputSecurePassword="tempSecurePass.txt";
            object.createFileContent(inputSecurePassword, newSecurePassword);

            System.out.println("creating keyStore ");
            createKeyStore(outPutFilePath+"/"+keyStoreFile, newStorePassword);

            encrypt128bit("FRANCONNECTPWISE",new File(inputStorePassword) , new File (outPutFilePath+"/storePassword.encrypted"));
            encrypt128bit("FRANCONNECTPWISE", new File(inputSecurePassword),new File (outPutFilePath+"/securePassword.encrypted"));

            System.out.println("New Key Store File Created at "+outPutFilePath+"/fcKeyStore.jceks");
            System.out.println("New Password Creadentials File Created at \n"+outPutFilePath+"/storePassword.encrypted"+"\n"+outPutFilePath+"/securePassword.encrypted");
            System.out.println("New Store Password : "+decrypt128bit("FRANCONNECTPWISE", new File(outPutFilePath+"/storePassword.encrypted")));
            System.out.println("New Secure Password : "+decrypt128bit("FRANCONNECTPWISE", new File(outPutFilePath+"/securePassword.encrypted")));

            File tempFile = new File(inputStorePassword);
            if(tempFile.exists())
            {
                tempFile.delete();
            }
            tempFile = new File(inputSecurePassword);
            if(tempFile.exists())
            {
                tempFile.delete();
            }
        }catch (Exception e ){
            System.out.println("**************Some Problem Occured**********************");
            e.printStackTrace();
        }

    }





    private void addNewKey()
    {
        try {
            System.out.println("Please Enter New File Encryption Key to encrypt secretKey.document ");
            String newEncryptionKey = sc.next();
            System.out.println("Please Enter Path Where you want to create encrypted file with new key(path of Directory) ");
            String outputDBKeyFilePath = sc.next();
            String inputDBKeyFilePath = "temp.txt";

            System.out.println(" Enter key to store in secretKey.document for data encryption ");

            String storeKey = sc.next();
            object.createFileContent(inputDBKeyFilePath, storeKey);

            System.out.println(" Enter credential that were used to create keystore.");
            getStorePasswordAndSecurePassword();

            object.putEntryInStore(outputDBKeyFilePath + "/fcKeyStore.jceks", keyStoreCredentials[0], newEncryptionKey, "fcStoreKey", keyStoreCredentials[1]);

            encrypt256bit(newEncryptionKey, new File(inputDBKeyFilePath), new File(outputDBKeyFilePath + "/secretKey.document.encrypted"));

            String key = object.getEntryInStore(outputDBKeyFilePath + "/fcKeyStore.jceks", keyStoreCredentials[0], "fcStoreKey", keyStoreCredentials[1]);
            String dBKeyNewFile = object.decrypt256bit(key, new File(outputDBKeyFilePath + "/secretKey.document.encrypted"));

            System.out.println("dBKeyNewFile >>" + dBKeyNewFile);
            System.out.println("New Encrypted File Created at " + outputDBKeyFilePath + "/secretKey.document.encrypted");
            System.out.println("New Key Store File Created at " + outputDBKeyFilePath + "/fcKeyStore.jceks");
            System.out.println(" The New Entry in key Store is " + key);
            File tempFile = new File(inputDBKeyFilePath);
            if (tempFile.exists()) {
                tempFile.delete();
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


    /**
     * @return a new pseudo random salt of the specified length
     */
    private static byte[] generateSalt(int length) {
        Random r = new SecureRandom();
        byte[] salt = new byte[length];
        r.nextBytes(salt);
        return salt;
    }
    /**
     * Derive an AES encryption key and authentication key from given password and salt,
     * using PBKDF2 key stretching. The authentication key is 64 bits long.
     * @param keyLength
     * length of the AES key in bits 256
     * @param password
     * the password from which to derive the keys
     * @param salt
     * the salt from which to derive the keys
     * @return a Keys object containing the two generated keys
     */
    private static class Keys {
        public final SecretKey encryption, authentication;
        public Keys(SecretKey encryption, SecretKey authentication) {
            this.encryption = encryption;
            this.authentication = authentication;
        }
    }
    private static Keys keygen(int keyLength, char[] password, byte[] salt) {
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance(KEYGEN_SPEC);
        } catch (Exception impossible) { return null; }
        // derive a longer key, then split into AES key and authentication key
        KeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, keyLength + AUTH_KEY_LENGTH * 8);
        SecretKey tmp = null;
        try {

            tmp = factory.generateSecret(spec);
        } catch (Exception impossible) { }
        byte[] fullKey = tmp.getEncoded();
        SecretKey authKey = new SecretKeySpec( // key for password authentication
                Arrays.copyOfRange(fullKey, 0, AUTH_KEY_LENGTH), "AES");
        SecretKey encKey = new SecretKeySpec( // key for AES encryption
                Arrays.copyOfRange(fullKey, AUTH_KEY_LENGTH, fullKey.length), "AES");
        return new Keys(encKey, authKey);
    }
    /**
     * Encrypts a stream of data. The encrypted stream consists of a header
     * followed by the raw AES data. The header is broken down as follows:<br/>
     * <ul>
     * <li><b>keyLength</b>: AES key length in bytes (valid for 16, 24, 32) (1 byte)</li>
     * <li><b>salt</b>: pseudorandom salt used to derive keys from password (16 bytes)</li>
     * <li><b>authentication key</b> (derived from password and salt, used to
     * check validity of password upon decryption) (8 bytes)</li>
     * <li><b>IV</b>: pseudorandom AES initialization vector (16 bytes)</li>
     * </ul>
     *
     * @param keyLength
     * key length to use for AES encryption (must be 128, 192, or 256)
     * @param password
     * password to use for encryption
     * @param input
     * an arbitrary byte stream to encrypt
     * @param output
     * stream to which encrypted data will be written
     */
    public  void encrypt256bit(String secretKey, File inputFile, File outputFile)throws Exception
    {
        // Check validity of key length
        char [] password= secretKey.toCharArray();
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try
        {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);
            // generate salt and derive keys for authentication and encryption
            byte[] salt = generateSalt(SALT_LENGTH);
            Keys keys = keygen(keyLength, password, salt);
            // initialize AES encryption
            Cipher encrypt = null;
            try {
                encrypt = Cipher.getInstance(CIPHER_SPEC);
                encrypt.init(Cipher.ENCRYPT_MODE, keys.encryption);
            }catch (Exception impossible) {
                impossible.printStackTrace();
            }
            // get initialization vector
            byte[] iv = null;
            try {
                iv = encrypt.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
            } catch (Exception impossible) { }
            // write authentication and AES initialization data
            outputStream.write(keyLength / 8);
            outputStream.write(salt);
            outputStream.write(keys.authentication.getEncoded());
            outputStream.write(iv);
            // read data from input into buffer, encrypt and write to output
            byte[] buffer = new byte[BUFFER_SIZE];
            int numRead;
            byte[] encrypted = null;
            while ((numRead = inputStream.read(buffer)) > 0) {
                encrypted = encrypt.update(buffer, 0, numRead);
                if (encrypted != null) {
                    outputStream.write(encrypted);
                }
            }
            try { // finish encryption - do final block
                encrypted = encrypt.doFinal();
            } catch (Exception impossible) {
                impossible.printStackTrace();
            }
            if (encrypted != null) {
                outputStream.write(encrypted);
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        finally
        {

            try
            {
                if(inputStream!=null)
                {
                    inputStream.close();
                    inputStream=null;
                }
                if(outputStream!=null){
                    outputStream.close();
                    outputStream=null;
                }
            }
            catch (Exception e)
            {
                // TODO: handle exception
                e.printStackTrace();
            }



        }

    }


    public  String decrypt256bit(String secretKey, File inputFile) throws Exception

    {
        ByteArrayInputStream object = null;
        InputStream input =null;
        ByteArrayOutputStream	baos = null;
        String plainText="";
        try
        {
            char [] password= secretKey.toCharArray();
            input = new FileInputStream(inputFile);
            int keyLength = input.read() * 8;
            // Check validity of key length
            // read salt, generate keys, and authenticate password
            byte[] salt = new byte[SALT_LENGTH];
            input.read(salt);
            Keys keys = keygen(keyLength, password, salt);
            byte[] authRead = new byte[AUTH_KEY_LENGTH];
            input.read(authRead);
            // initialize AES decryption
            byte[] iv = new byte[16]; // 16-byte I.V. regardless of key size
            input.read(iv);
            Cipher decrypt = null;
            try {
                decrypt = Cipher.getInstance(CIPHER_SPEC);
                decrypt.init(Cipher.DECRYPT_MODE, keys.encryption, new IvParameterSpec(iv));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // read data from input into buffer, decrypt and write to output
            byte[] buffer = new byte[BUFFER_SIZE];
            int numRead;
            byte[] decrypted=null;
            while ((numRead = input.read(buffer)) > 0) {
                decrypted = decrypt.update(buffer, 0, numRead);
            }

            decrypted = decrypt.doFinal();

            baos = new ByteArrayOutputStream();
            baos.write(decrypted);

            object = new ByteArrayInputStream(baos.toByteArray());
            int c;
            while(( c= object.read())!= -1)//10 is ASCII for new line character
            {
                if(c==10){
                    break;
                }
                plainText+=(char)c;
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {

            try
            {
                if(input!=null)
                {
                    input.close();
                    input=null;
                }
                if(baos!=null){
                    baos.close();
                    baos=null;
                }
                if(object!=null){
                    object.close();
                    object=null;
                }
            }
            catch (Exception e)
            {
                // TODO: handle exception
                e.printStackTrace();
            }



        }

        return plainText;

    }

    public  void putEntryInStore(String keyStoreFile,String storePassword,String entryValue,String keyStoreKey,String extraPassword) throws Exception
    {
        KeyStore keyStore = createKeyStore(keyStoreFile, storePassword);
        SecretKey secretKey = new SecretKeySpec(entryValue.getBytes(), "AES");
        KeyStore.SecretKeyEntry keyStoreEntry = new KeyStore.SecretKeyEntry(secretKey);
        KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(extraPassword.toCharArray());
        keyStore.setEntry(keyStoreKey, keyStoreEntry, keyPassword);
        keyStore.store(new FileOutputStream(keyStoreFile), storePassword.toCharArray());
    }
    public String getEntryInStore(String keyStoreFile,String storePassword,String keyStoreKey,String extraPassword) throws Exception
    {
        KeyStore keyStore = createKeyStore(keyStoreFile, storePassword);
        KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(extraPassword.toCharArray());
        KeyStore.Entry entry = keyStore.getEntry(keyStoreKey, keyPassword);
        SecretKey keyFound = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        return base64String(keyFound);
    }

    private  KeyStore createKeyStore(String fileName, String pw) throws Exception {
        File file = new File(fileName);

        final KeyStore keyStore = KeyStore.getInstance("JCEKS");
        if (file.exists()) {
            // .keystore file already exists => load it
            keyStore.load(new FileInputStream(file), pw.toCharArray());
            System.out.println("Existing .keystore file loaded!");
        } else {
            // .keystore file not created yet => create it
            keyStore.load(null, null);
            keyStore.store(new FileOutputStream(fileName), pw.toCharArray());
            System.out.println("New .keystore file created!");
        }

        return keyStore;
    }

    private  String base64String(SecretKey secretKey) {
        String plainText="";
        try{
            ByteArrayOutputStream	baos = new ByteArrayOutputStream();
            baos.write(secretKey.getEncoded());

            ByteArrayInputStream object = new ByteArrayInputStream(baos.toByteArray());
            int c;
            while(( c= object.read())!= -1)//10 is ASCII for new line character
            {
                if(c==10){
                    break;
                }
                plainText+=(char)c;
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return plainText;
    }




    public void createFileContent(String filePath,String content) throws Exception{
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
        fw.close();
    }

    public void encrypt128bit(String key, File inputFile, File outputFile)throws Exception
    {
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try
        {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(inputStream!=null)
                {
                    inputStream.close();
                    inputStream=null;
                }
                if(outputStream!=null){
                    outputStream.close();
                    outputStream=null;
                }
            }
            catch (Exception e)
            {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

    }



    public  String decrypt128bit(String key, File inputFile)
    {
        FileInputStream inputStream=null;
        ByteArrayOutputStream baos=null;
        ByteArrayInputStream object=null;
        String plainText="";
        try{
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);


            baos = new ByteArrayOutputStream();
            baos.write(outputBytes);
            object = new ByteArrayInputStream(baos.toByteArray());
            int c;
            while(( c= object.read())!= -1)//10 is ASCII for new line character
            {
                if(c==10)
                    break;
                plainText+=(char)c;
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally{
            try{
                if(inputStream!=null)
                {
                    inputStream.close();
                    inputStream=null;
                }
                if(baos!=null){
                    baos.close();
                    baos=null;
                }
                if(object!=null){
                    object.close();
                    object=null;
                }
            }
            catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

        return plainText;
    }



}

