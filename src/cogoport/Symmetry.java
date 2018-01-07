package cogoport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 7/1/18.
 *
 *You want to make a Special binary number of length
 N, by repeating an another binary number of
 K size in length.

 Special binary number of size
 N should have following properties:

 1) It should be a palindrome.
 2) It should contain at least one
 0 and one 1.
 3) It should not contain preceding zeros.

 There is no restriction on
 K size binary number.

 If the size of the special binary number on repetitively concatenating the
 K size binary number becomes greater than
 N, then you need to trim it to first
 N characters.

 Note:
 1) Binary number contains only 1 and 0.
 2) Palindrome is a sequence that reads the same backwards as forwards .

 Input

 First line of the input contains the number of test cases
 T. It is followed by T lines. Each line contains two integers
 N and  K.

 Output

 For each test case, output a special binary number of length
 N in an new line.
 If you think there can exist more than one such special numbers,
 print the one which contains largest number of zeros.
 If no such number is possible, print "impossible" without the quotation marks.
 *
 *
 Constraints

 1<=T<=10

 1<=N,K<=10^5

 *
 *
 *
 Sample Input
 5
 16 8
 8 2
 9 5
 20 9
 2 1

 Sample Output
 1000000110000001
 impossible
 100101001
 11000000011000000011
 impossible



 solution thesis: we using brute form >>
 as question says k must has to have one 0,1  and we need to give priority to max zero set of k

 so we make set of permutations possible k and make fit in N size array

 Now check if its palindrome

 */


public class Symmetry {



    public static void main(String[] args) {

        String inp="";
        BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));


        try {
            int test = Integer.parseInt(inpReader.readLine());

            while (test > 0){

                inp = inpReader.readLine();
                int N = Integer.parseInt(inp.split(" ")[0]);
                int K = Integer.parseInt(inp.split(" ")[1]);
                char[] mainArray = new char[N];

                Set<String> tryset = makeRepeatSet(K);

                for (String trial : tryset) {
                    char[] temp = trial.toCharArray();

                    for (int i = 0; i < N; i=i+K) {

                        for (int j = 0; j < temp.length; j++) {
                            if (N  > (i+j) ){
                                mainArray[i + j] = temp[j];
                            }

                        }
                    }

                    System.out.println("  >> mainArra >> "+String.valueOf(mainArray));

                    if (isPalindrome(mainArray)){
                        System.out.println("  found >> "+String.valueOf(mainArray));
                        break;
                    }
                }
                test --;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static boolean isPalindrome(char[] s){
        /*int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }*/

        int n = s.length;
        for (int i = 0; i < (n/2); ++i) {
            if (s[i] != s[n - i - 1]) {
                return false;
            }
        }
        return true;
    }



    // find all permutation of K array

    static Set<String> makeRepeatSet(int sizeOfRepeat){
        Set<String> repeat = new LinkedHashSet<>();

        int[] x = new int[sizeOfRepeat];
        x[0]=1;

        int countOfOne=1;           // 1000
        while (countOfOne <= sizeOfRepeat-1){

            for (int i = 0; i < x.length-1; i++) {
                x[i] = 1;
                StringBuilder temp = new StringBuilder(sizeOfRepeat);
                for (int num : x) {
                    temp.append(num);
                }
                repeat.add(temp.toString());
            }

        }

 /*       for (int i = 0; i < x.length-1; i++) {
            x[i] = 1;
            StringBuilder temp = new StringBuilder(sizeOfRepeat);
            for (int num : x) {
                temp.append(num);
            }
            repeat.add(temp.toString());
        }
*/
        return repeat;
    }

}
