package lensKart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sachin on 3/2/18.
 */
public class StringsCount {

    static     String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {


        try {
            int test = Integer.parseInt(inpReader.readLine());

            int[] charBuffer;
            while (test > 0){
                inp = inpReader.readLine();
                int count = 0;
                if (inp !=null) {
                    charBuffer = new int[26];

                    for (char c : inp.toCharArray()) {
                        System.out.println(c+0);
                        charBuffer[Math.abs(c - 97)]++;
                    }

                    for (int x : charBuffer) {
                        if (x != 0) {
                            count++;
                        }
                    }
                }
                if (count%2 ==0){
                    System.out.println("Player2");
                }else {
                    System.out.println("Player1");
                }
                test--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
