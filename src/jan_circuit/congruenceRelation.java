package jan_circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sachin on 20/1/18.
 */
public class congruenceRelation {

    static     String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int number=0;
        int div =0;

        try {

            inp = inpReader.readLine();
            number= Integer.parseInt(inp.split(" ")[0]);
            div= Integer.parseInt(inp.split(" ")[1]);

            long [] divs =new long[div];

            System.out.println(System.nanoTime()/1000000000);
            for (int i = 1 ; i <= number; i++) {
                 int x = i & (div -1 );
                //int x = i%div;
                divs[x] =++divs[x];
            }
            System.out.println(System.nanoTime()/1000000000);

            long outCount=0;
            for (long elementCount : divs) {
                long sum =0;
                for (int i = 1; i < elementCount; i++) {
                    sum +=i;
                }
                outCount = outCount + sum;

            }

            System.out.println(System.nanoTime()/1000000000);

            System.out.println(outCount);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
