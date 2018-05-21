package thoughtWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 5/5/18.
 */
public class GreaterString {


    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            inp =inpReader.readLine();
            int size= Integer.parseInt(inp.split(" ")[0]);

            int test= Integer.parseInt(inp.split(" ")[1]);

            char[] a =inpReader.readLine().toCharArray();
            char[] b =inpReader.readLine().toCharArray();



            int aIndex = String.valueOf(a).indexOf('0');
            int bIndex = String.valueOf(b).indexOf('0');

            while (test>0){

                int index =Integer.parseInt(inpReader.readLine());
                 b[index-1]='1';

                if (bIndex==index-1){
                    bIndex = String.valueOf(b).indexOf("0");
                }

                 if (bIndex==-1){
                     System.out.println("YES");
                 }else if (aIndex !=-1 && (bIndex >= aIndex)){
                     System.out.println("YES");
                 }else {
                     System.out.println("NO");
                 }

                test--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
