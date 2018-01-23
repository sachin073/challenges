package jan_circuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 23/1/18.
 */
public class ArraysMin {
    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    static int len,mod;

    public static void main(String[] args) {

        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();

            len = Integer.parseInt(inp.split(" ")[0]);
            mod = Integer.parseInt(inp.split(" ")[1]);


            long[] a = new long[len];

            long[] b = new long[len];

            long[] c = new long[len];

            int tempLen =len;
            int i=0;
            while (tempLen > 0){
                inp = inpReader.readLine();

                int ai= Integer.parseInt(inp.split(" ")[0]);
                int bi= Integer.parseInt(inp.split(" ")[1]);
                int ci= Integer.parseInt(inp.split(" ")[2]);

                a[i] =ai; b[i]=bi; c[i]= ci;
                i++;
                tempLen-- ;
            }

            long minOfMax =-1;

            long[] sumi= new long[len];

            for (int k = 1; k < mod; k++) {

                 long maximum = 0;
                Arrays.fill(sumi,0);
                for (int j = 0; j < len; j++) {

                    a[j] = (a[j] + 1) % mod ;
                    b[j] = (b[j] + 1) % mod ;
                    c[j] = (c[j] + 1) % mod ;

                    sumi[j] =sumi[j] + a[j]+b[j] +c[j];

                    if (sumi[j] > maximum){
                        maximum = sumi[j];
                    }

                }

             /*   System.out.println(Arrays.toString(a));
                System.out.println(Arrays.toString(b));
                System.out.println(Arrays.toString(c));
*/
            if (minOfMax == -1){
                minOfMax = maximum;
            }else if (minOfMax > maximum) {
                minOfMax = maximum;
            }

//                System.out.println(minOfMax +" >>> "+ maximum);

            }

            System.out.println(minOfMax);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
