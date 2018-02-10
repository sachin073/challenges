package lensKart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sachin on 4/2/18.
 *

 Given an array
 A
 A having
 N
 N distinct integers.

 The power of the array is defined as:
 max(A[i]−A[j]) where 2≤i≤N
 for each
 i,j is the largest index less than
 i such that
 A[j]<A[i].
 Let's say the array is {1,2,5}, then the power of the array is
 max((2−1),(5−2)) , which simplifies to
 max(1,3) which is equal to 3.

 Operation Allowed:
 If you are allowed to choose any two indices
 x and y
 y and swap
 A[x] and
 A[y], find out the maximum power that can be achieved.

 Note: You are allowed to perform the above operation at most once.

 Input:
 First line consists of a single integer,
 T, denoting the number of test cases.
 First line of each test case consists of a single integer, denoting
 N.
 Second line of each test case consists of
 N space separated integers denoting the arrayA.

 Output:
 For each test case, print the maximum achievable power on a new line.

 Constraints:
 1≤T≤10
 2≤N≤105
 Sample Input
 2
 2
 9 10
 4
 2 3 4 1
 Sample Output
 1
 3
 Explanation
 In the first test case, we don't need to do any swaps, the max achievable power is 1.
 In second test case we can swap
 A
 [
 3
 ]
 A[3] and
 A
 [
 4
 ]
 A[4] so the array will be 2 3 1 4 and the power will be 3.



 */
public class MaxPower {

    static     String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {


        try {
            int test = Integer.parseInt(inpReader.readLine());

            while (test>0){
                int len = Integer.parseInt(inpReader.readLine());

                inp = inpReader.readLine();
                int[] arr = new int[len];
                int[] dif = new int[len];
                int i=0;
                for (String string :inp.split(" ")) {
                    arr[i] = Integer.parseInt(string);
                        i++;
                }

                int maxDiff=0;
                for (i = 0; i < arr.length; i++) {

                    if (i>0){
                        dif[i-1] = arr[i] - arr[i-1];
                        if (maxDiff < dif[i-1]){
                            maxDiff = dif[i-1];
                        }
                    }

                }

                int maxSwapAssumed =maxDiff;
                //single max diff
                int[] arrClone = arr.clone();
                for (int j = 0; j < dif.length; j++) {
                    // try swap
                    if (arr[j] < dif.length ){
                    }

                }


                test--;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
