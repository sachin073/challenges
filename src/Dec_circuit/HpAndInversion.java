package Dec_circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by fran on 12/22/17.
 */
public class HpAndInversion {

    static int[] list ;

    public static void main(String[] args) {

        try {
            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(str.readLine());

            while (test>0){
                int listSize = Integer.parseInt(str.readLine());
                String temp = str.readLine();

                list=new int[listSize];
                int x=0;
                for (String string:temp.split(" ")) {
                    //list.add(Integer.parseInt(string));
                    list[x] =Integer.parseInt(string);
                    x++;
                }

                System.out.println(list);
                int roto=0;
                while(listSize > 0){

                    //Collections.rotate(list,-1);
                    roto++;
                    int[] rotatedArray= rotate(listSize,roto);
                    int count=0;
                    System.out.println(list);
                    for (int j = 0; j < list.length; j++) {

                        for (int i = j+1; i < list.length; i++) {
                            if ( list[j] > list[i] ){
                                count++;
                            }
                        }
                    }
                    System.out.print(count+" ");
                  listSize--;
                }

                test--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static private int[] rotate(int sizeOfArray,int rotation){

        int[] returnArray= new int[sizeOfArray];

        returnArray = Arrays.copyOfRange(list,rotation,sizeOfArray);

        int startFill= sizeOfArray-rotation;

        for (int i = 0; i < rotation; i++) {
            returnArray[startFill] = list[i];
        }

        return returnArray;
    }

}
