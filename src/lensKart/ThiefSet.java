package lensKart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 3/2/18.
 */
public class ThiefSet {

    static     String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {


        try {
            int test = Integer.parseInt(inpReader.readLine());

            int len = 0;
            while (test > 0){
                len = Integer.parseInt(inpReader.readLine());
                long[] array = new long[len];

                long sum=0;         // can be bigInt
                inp = inpReader.readLine();
                int i=0;
                for (String string :inp.split(" ")) {
                    array[i] = Long.parseLong(string);  // bigint
                    i++;
                }
                //System.out.println(Arrays.toString(array));
                generatePowerSet(array);

                test--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void generatePowerSet(long[] arr){

        int n = arr.length;

        long[][] samples = new long[1<<n][n];

        long maxOfSet=-1;
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            long min =-1;
            int setLen=0;
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[j] + " ");
                    if (min == -1){
                        min = arr[j];
                    }else if (min > arr[j]){
                        min = arr[j];
                    }
                    setLen++;
                    samples[i][j] = arr[j];
                }

            if (maxOfSet == -1) {
                maxOfSet = min * setLen;
            }else if(maxOfSet < (min*setLen)){
                maxOfSet = min*setLen;
            }

            System.out.println("}");
            System.out.println(maxOfSet+ " " +setLen) ;
        }

       // System.out.println(Arrays.toString(samples));
        System.out.println(maxOfSet);
    }


}
