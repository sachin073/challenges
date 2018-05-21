package thoughtWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sachin on 5/5/18.

 Let's say 1,2,3 are the only digits which exists in a unique number system, so the numbers will be 1,2,3,11,12,13,21.... in ascending order .

 1st number is 1 and number of digits is 1

 4th will be 11 and number of digits is 2

 14th will be 112 and number of digits will be 3

 40th will be 1111 and number of digits will be 4

 */
public class Digits {


    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            int test= Integer.parseInt(inpReader.readLine());

        while (test>0){
            BigInteger bg= new BigInteger(inpReader.readLine());

            int i=1;
            BigInteger sum =new BigInteger("3");
            while (sum.compareTo(bg) < 0 ){
                i++;

                BigInteger pow= new BigInteger("3").pow(i);
                sum =  pow.add(sum);
            }
            System.out.println(i);

            test--;
        }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
