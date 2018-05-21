package jan_circuit;

import com.company.algo.KruskalMST;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by sachin on 27/1/18.
 */

public class ArrayQuery {
    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    static int[] array=null;
    public static void main(String[] args) {

        int size,queries;
        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();

            size = Integer.parseInt(inp.split(" ")[0]);
            queries= Integer.parseInt(inp.split(" ")[1]);

            array = new int[ (int) Math.pow(2,size)];

            inp = inpReader.readLine();
            String[] arr = inp.split(" ");
            int i=0;
            for (String string:arr) {
                array[i]= Integer.parseInt(string);
                i++;
            }
            i=0;

            while (queries > 0){

                inp = inpReader.readLine();
                arr=inp.split(" ");

                if ("1".equals(arr[0])){
                    query1(arr[1],arr[2]);

                }else if ("2".equals(arr[0])){
                    query2(arr[1],arr[2],arr[3]);

                }else if ("3".equals(arr[0])){
                    query3(arr[1]);

                }

                queries--;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //find max
    static void query1(String start, String end){

        int i = Integer.parseInt(start);
        int j = Integer.parseInt(end);

        int max=array[i];
        for (int k = i; k <=j; k++) {

            if (array[k] > max){
                max = array[k];
            }

        }
        System.out.println(max);
    }

    // replace
    static void query2(String start, String end , String replacement ){
        int i = Integer.parseInt(start);
        int j = Integer.parseInt(end);
        int replace = Integer.parseInt(replacement);
        Arrays.fill(array,i,j+1,replace);

    }

    // permute
    static void query3(String k){

        int mod = Integer.parseInt(k);
        int[] modArr = new int[array.length];

        int fillIndex=0;
        /*for (int i = mod; i >=0 ; i--) {
                modArr[fillIndex] = array[i];
                fillIndex++;
        }

        for (int i = array.length-1; i >mod ; i--) {
            modArr[fillIndex] = array[i];
            fillIndex++;
        }*/

        for (int i = 0; i <array.length; i++) {
            fillIndex = i ^ mod;
            modArr[fillIndex] = array[i];
        }


        System.out.println(Arrays.toString(modArr));
        array = modArr;
    }


}
