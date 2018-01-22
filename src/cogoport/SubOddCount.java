package cogoport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sachin on 6/1/18.
 */
public class SubOddCount {


    static int count=0;
    public static void main(String[] args) {

        String inp="";
        BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            inp = inpReader.readLine();

            int sublenth =0;
            while (sublenth != inp.length()) {
                sublenth++;
                for (int i = 0; i < inp.length(); i++) {
                   // System.out.println("i>>"+i+"  sum "+sublenth+ " ..sum"+(i+sublenth)+ " .<>"+inp);
                    if (inp.length() >= (i+sublenth)) {
                         String temp = inp.substring(i, i + sublenth);
                            countOdd(temp);
                    }
                }
            }

            System.out.printf(count+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static BigInteger binaryToDecimal(String n)
    {
        String num = n;
        BigInteger dec_value = new BigInteger("0");
        BigInteger zero_value = new BigInteger("0");
        BigInteger one_value = new BigInteger("0");

        // Initializing base value to 1,
        // i.e 2^0
        BigInteger base = new BigInteger("1");

        int len = num.length();
        for (int i = len - 1; i >= 0; i--)
        {
            if (num.charAt(i) == '0')
            {
                //dec_value += 0 * base;
                dec_value = dec_value.add(zero_value.multiply(base));

//                dec_value.add(zero_value).add(new BigInteger(base+""));
//                base = base * 2;
                base = base.multiply(new BigInteger("2"));
            }
            else
            {
                dec_value = dec_value.add(one_value.multiply(base));
                //dec_value += 1 * base;
                base = base.multiply(new BigInteger("2"));

//                base = base * 2;
            }
        }

        return dec_value;
    }

    private static void countOdd(String str){
        //System.out.println("checked "+str+ str.lastIndexOf("0") +"<><"+str.length());

        if (str.equals("0")){
            return;
        }
        while (str.lastIndexOf("0")==(str.length()-1)){
            str = str.substring(0,str.length()-1);
        }
           // System.out.println("checked  after "+str);
              BigInteger in =  binaryToDecimal("1111111111111111110000000000000000111");


            if (in.mod(new BigInteger("2")).equals(new BigInteger("0"))){
              //  System.out.println("number>>"+str);
                count++;
            }


    }

}
