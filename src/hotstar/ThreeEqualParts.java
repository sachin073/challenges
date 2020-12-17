package hotstar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sachin on 7/7/18.
 */
public class ThreeEqualParts {

    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {


        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            inp = inpReader.readLine();
            int test = Integer.parseInt(inp);


            while (test >0){


                inp = inpReader.readLine();
                int size = Integer.parseInt(inp);

                inp = inpReader.readLine();
                String[] data = inp.split(" ");

                
                test--;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
