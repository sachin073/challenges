package jan_circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sachin on 21/1/18.


 1 2 50 6 2 1 2 3 4 4 1

 1 2  3 4 5 6 7 8
 1 50 6 2 6 2 3     K =5

 1 3
 1 4 5
 1 4 6 7




 1
 1 2 4
 1 2 4            5
 1 2 5 6
 1 2 5 7 8


 1 2 5 6 7 8    k 4  elements 6 max 8

 break if max elements >  max elements now found , work max elements <= max now

 1 2 6 7 8




 1 > 2 3 4 5 6 7 8


 2 > 3 4 5 6 7 8
 3 > 4 5 6 7 8
 4 > 5 6 7 8
 5 > 6 7 8
 6 > 7 8
 7 > 8




 */
public class Roads {

    static String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int len, time;

        try {
            inp = inpReader.readLine();
            len = Integer.parseInt(inp.split(" ")[0]);
            time = Integer.parseInt(inp.split(" ")[1]);

            int[] arr = new int[len];
            inp = inpReader.readLine();
            String[] strings = inp.split(" ");

            int source =Integer.parseInt(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }

            Arrays.sort(arr);

            int points = 1;

            for (int i = 1; i < arr.length; i++) {

                if (time ==0){
                    break;
                }
                if ( Math.abs(arr[i] - source)  <= time){
                    source = arr[i];
                    time = time - Math.abs(arr[i] -source);
                    points++;
                }

            }

            System.out.println(points);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
