package paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sachin on 2/6/18.
 *
 You have to design a new model which maps an even length palindromic number to some digit between 0 to 9.
 The number is mapped to a digit x on the basis of following criteria:
 1. x should appear maximum number of times in the palindromic number, that is, among all digits in the number, x should appear maximum number of times.
 2. If more than one digit appears maximum number of times, x should be the smallest digit among them.

 Given an integer N, you have to find the digit x for the Nth even length palindromic number.

 Note- First 9 even length palindromic numbers are:

 11, 22, 33, 44, 55, 66, 77, 88, 99

 Input :

 First line contains T, number of test cases.

 Each of the next T lines contains an integer N.

 Sample Input
 3
 1
 2
 10

 Sample Output
 1
 2
 0


 *
 */
public class PalinDigit {

  static List<String> palins = new ArrayList<>();
static {
    palins.add("11");
}
  static int maxPos =0;

    public static void main(String[] args) {


    


    }


    public static String getPalins(int pos) {


        for (int i = maxPos; i < pos; i++) {
            String palin = palins.get(maxPos);

            String next = nextPlain(palin);
            palins.add(next);
            maxPos++;
        }

        return palins.get(maxPos-1);
    }

   static String nextPlain(String palin){

        String half = palin.substring(0,(palin.length()/2)-1);

        long number = Integer.parseInt(half);

        number++;

        half = String.valueOf(number);
        half = half + new StringBuilder(half).reverse().toString();
        return half;
    }


}
