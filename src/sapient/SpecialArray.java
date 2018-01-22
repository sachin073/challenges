package sapient;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sachin on 10/12/17.
 */
public class SpecialArray {

    static int [] numbers=null;

    public static void main(String[] args) {

        try {
            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(str.readLine());

            numbers = new int[test];
            int i=0;
            for (String string:  str.readLine().split(" ") ) {
               numbers[i]= Integer.parseInt(string);
               i++;
            }

            ArrayList<Integer> sortedPrime = new ArrayList<>();
            ArrayList<Integer> sortedNonPrime = new ArrayList<>();

            for (int x:numbers) {
                boolean isPrime =isPrime(x);
                if (isPrime){
                    sortedPrime.add(x);
                }else{
                    sortedNonPrime.add(x);
                }
            }

            Collections.sort(sortedPrime);
            Collections.sort(sortedNonPrime,Collections.reverseOrder());

            sortedPrime.addAll(sortedNonPrime);


            for (int ints:sortedPrime) {
                System.out.print(ints+" ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static boolean  isPrime(int n)
    {
        // Corner cases
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n%2 == 0 || n%3 == 0) return false;

        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
                return false;

        return true;
    }

}
