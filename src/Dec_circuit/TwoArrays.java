package Dec_circuit;

/*
1 2 3
1 2 3

11 22 33

12 12  12 23  23 12  23 23

123 123


5 5 1 2 3   if a[i]!=b[j]
6 5 1 2 3

                        k=1
55 11 22 33 55

55 65   51 65   51 51   12 51   12 12   23 12   23 23 k1

551 651  551 123  551 512


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sachin on 20/12/17.
 */
public class TwoArrays {

    static int[] arrayA = null;
    static int[] arrayB = null;
    static int sizeOfA,sizeOfB,k;
    public static void main(String[] args) {

        BufferedReader inpReader  = new BufferedReader(new InputStreamReader(System.in));


        String temp= null;
        try {
            temp = inpReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sizeOfA = Integer.parseInt(temp.split(" ")[0]);
        sizeOfB = Integer.parseInt(temp.split(" ")[1]);
        k = Integer.parseInt(temp.split(" ")[2]);
        arrayA = new int[sizeOfA];
        arrayB = new int[sizeOfB];

        try {

            temp = inpReader.readLine();
            int i=0;
            for (String string :temp.split(" ")) {
                arrayA[i]=Integer.parseInt(string.trim());
                i++;
            }

            temp = inpReader.readLine();
            i=0;
            for (String string :temp.split(" ")) {
                arrayB[i]=Integer.parseInt(string.trim());
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<String> sampleSpace = new HashSet<>();

        int[] tempSpace =null;
        int matchCount=0;
        for (int m = 0; m < sizeOfA; m++) {
            tempSpace = new int[m + 1];
            for (int i = 0; i < sizeOfA; i++) { //
                //fill array start from i to size of tempSpace
                for (int x=i,loc=0; loc < tempSpace.length && x < arrayA.length ; x++,loc++ ) {
                    tempSpace[loc]=arrayA[x];
                }

                int[] copyOfB = arrayB.clone();
                int x = findMatchings(tempSpace, copyOfB);

                while (x != -1) {
                    matchCount++;
                    copyOfB[x] = -1;
                    x = findMatchings(tempSpace, copyOfB);
                }

            }
        }

        System.out.println("<><><count match>"+matchCount);

    }


    // if -1 no match found else match stating index
    private static int findMatchings(int[] matcher,int[] arrayB){
        int sizeOfMatcher= matcher.length;

        //find one pattern and remove one from start or remove from till start of found -1
        for (int i = 0; i < matcher.length; i++) {

            for (int j = 0; j < sizeOfB ; j++) {
                if (arrayB[j] == matcher[i]){
                        int arrayIndex=j;
                        boolean match=true;
                        int matcherIndex=i;
                        int timesMatchCount=0;
                        boolean actualMatch = false;
                        while(match && matcherIndex < sizeOfMatcher ){
                            timesMatchCount++;
                            if (arrayB[arrayIndex]==matcher[matcherIndex]){
                                match = true;
                                arrayIndex++;
                                matcherIndex++;
                            }else {
                                match = false;
                            }
                            if (timesMatchCount==k) {
                                actualMatch=true;
                                break;
                            }
                        }
                        if (actualMatch && (sizeOfMatcher <= sizeOfB-(j) )){  //size of matcher and array is equal
                            return j;
                        }
                    }
            }
        }

        return -1;
    }


}


