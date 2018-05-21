package dell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sachin on 12/5/18.
 *
 You are given an array A of size N

 Find the minimum non negative number X such that there exist an index j and when you can replace Aj by Aj+X, the sum of elements of array from index 1 to j  and j+1 to  N becomes equal, where 1≤j≤N−1. Assume array to be 1-indexed.

 If there is no possible X print −1 in separate line.

 Input Format

 The first line contains T, the number of test cases.
 For each Test case :
 The first line contains an integer N, size of the array.
 The second line contains N space-separated integers, the ith of which is Ai.


 *
 *
 */
public class EqualArray {

    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            int test= Integer.parseInt(inpReader.readLine());

            while (test>0){

                int size =  Integer.parseInt(inpReader.readLine());

                int[] arr = new int[size];
                inp =inpReader.readLine();
                int i=0;
                int sum =0;
                for (String str :inp.split(" ")) {
                    arr[i] = Integer.parseInt(str);
                    sum += arr[i];
                    i++;
                }

                int balancingLoad=0;
                int rightLoad = sum;
                int leftSum = 0;
                int j = 0;
                for ( j = 0; j < i ; j++) {
                    leftSum = leftSum +arr[j];      //1
                    rightLoad = rightLoad - arr[j]; // 8

                    if ( (rightLoad > leftSum) && (balancingLoad > rightLoad -leftSum || balancingLoad ==0) && (leftSum +(rightLoad -leftSum ) == rightLoad ) ) {
                        balancingLoad = rightLoad - leftSum;
                    }

                }

                if (balancingLoad !=0) {
                    System.out.println(balancingLoad);
                } else {
                    System.out.println(-1);
                }
                test--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
