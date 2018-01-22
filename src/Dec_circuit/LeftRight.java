package Dec_circuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sachin on 22/12/17.
 */
public class LeftRight {

    static int[] city=null;
    static int citySize=0;
    public static void main(String[] args) {

        BufferedReader inpReader  = new BufferedReader(new InputStreamReader(System.in));
        try {
            String temp = inpReader.readLine();

            citySize = Integer.parseInt(temp.split(" ")[0]);
            int queries = Integer.parseInt(temp.split(" ")[1]);

            city = new int[citySize];
            temp = inpReader.readLine();
            int i=0;
            for (String string : temp.split(" ")) {
                city[i] = Integer.parseInt(string);
                i++;
            }

            while (queries>0){
                temp = inpReader.readLine();
                int indexOfStart = Integer.parseInt(temp.split(" ")[0]);

                int steps = findCity(indexOfStart,Integer.parseInt(temp.split(" ")[1]),temp.split(" ")[2]);
                if (steps == -1){
                    System.out.println("-1");
                }else {
                    System.out.println(steps);
                }


                queries--;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static int findCity(int start, int cityToFind, String direction){
        int steps=0;
        boolean found=false;
        for (int x:city ) {
            if (x==cityToFind){
                found =true;
            }
        }

        if (found==false){
            return -1;
        }
        while ( start >=0 && start < citySize  ){

            if (city[start] == cityToFind){
                break;
            }

            steps++;
            if ("R".equals(direction)){
                start++;
                start= start % citySize;
            }else {
               start= (start - 1 + citySize) % citySize;
            }
        }
        return steps;
    }
}
