package dell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 12/5/18.


 You are given T tasks to perform. In each task, you are given a string S of length N. You are allowed to select any two indices i and j (i!=j) of the given string and perform exactly one swap between the characters at these indices.

 If it is possible to make the new string a palindrome then print "Yes", else print "No".

 Note:

 A string is said to be palindrome if it reads same as its reverse form. For example: "madam" , "dad" etc.



 */
public class SwapToPalindrome {

    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {

        try {
            int test= Integer.parseInt(inpReader.readLine());
            /*while (test>0){
                inp = inpReader.readLine();
                char[] inpArr = inp.toCharArray();




                boolean found =false;
                for (int i = 0; i < inpArr.length; i++) {
                    for (int j = i+1; j <inpArr.length ; j++) {

                        char temp = inpArr[j];
                        inpArr[j] = inpArr[i];
                        inpArr[i] = temp;
                        if (checkPalin(inpArr)){
                            found =true;
                            break;
                        }else {
                            temp = inpArr[i];
                            inpArr[i] = inpArr[j];
                            inpArr[j] = temp;
                        }
                     }
                }

                if (found){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }

                test--;
            }*/


            while (test>0){
                inp = inpReader.readLine();
                char[] inpArr = inp.toCharArray();
                int len =inpArr.length-1;
                int mid =0;
                if (len%2==0) {
                    mid = inpArr.length/2;
                }else {
                    mid = (inpArr.length-1) /2 ;

                }



                for (int i = 0; i <=mid ; i++) {
                    if (inpArr[i] != inpArr[len]){

                        findIndex(inpArr,inpArr[i],inpArr[len],i);

                       }

                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static String findIndex(char[] palin,char i,char j ,int index) {
        String string = String.valueOf(palin);

        string =string.substring(index+1,string.length()-index-1);

        int indexOfi = string.indexOf(i);
        char charAti = string.charAt(indexOfi);

        //replace i and char for replacement
        char temp = palin[i];
        palin[i] = charAti;
        palin[indexOfi] = temp;



        int indexOfj = string.indexOf(j);
        char charAtj = string.charAt(indexOfj);


        return "";
    }


        static boolean checkPalin(char[] palin){
        int len = palin.length-1;
        int mid=0;
        if (len%2==0){
            mid = len/2;
            String string = String.valueOf(palin);

            for (int i = 0; i <= mid; i++) {
                    if (palin[i]!=palin[len-i]){
                        return false;
                    }
            }

        }else {
            mid = len/2 +1;
            for (int i = 0; i < mid; i++) {
                if (palin[i]!=palin[len-i]){
                    return false;
                }
            }

        }


    return true;

    }


}
