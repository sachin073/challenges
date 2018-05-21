package Airtel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sachin on 18/3/18.
 */
public class PowerSetSimple {

    static String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {


        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();

            int size = Integer.parseInt(inp);


            inp = inpReader.readLine();

            int[] arr = new int[size]; // o is even ,1 is odd
            int i=0;
            for (String ch:inp.split(" ") ) {

                arr[i] = Integer.parseInt(ch);

                arr[i] = arr[i]%2==0 ? 0 : 1;
                i++;
            }

            i=0;


            int evenCount,oddCount;
            int count=0;
            for (i = 0; i < arr.length; i++) {

                evenCount=0;
                oddCount=0;
                for (int j = i; j < arr.length; j++) {

                    if (arr[j]==0)
                        evenCount++;
                    else
                        oddCount++;

                    if (evenCount == oddCount)
                    count++;
                }

            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
