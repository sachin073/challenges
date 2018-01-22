package sapient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sachin on 9/12/17.
 */
public class GameOfNumber {

  public static long[] numbers ;

    public static void main(String[] args) {


        try {
            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(str.readLine());

             numbers = new long[test];

            for (int i = 0; i < test; i++) {
                numbers[i] = Long.parseLong(str.readLine());
            }


            for (int i = 0; i < numbers.length; i++) {
                int largeOnIndex= getNextLarge(i);
                if (largeOnIndex == -1){
                    System.out.print("-1 ");
                    continue;
                }
                int smallOnIndex = getNextSmaller(largeOnIndex);
                if (smallOnIndex == -1){
                    System.out.print("-1 ");
                    continue;
                }
                System.out.print(numbers[smallOnIndex]+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static int getNextLarge(int indexOfStart){

        long numberOnIndex = numbers[indexOfStart];
        int index=0;
        boolean largeFound=false;

        for (int i = indexOfStart; i <numbers.length ; i++) {

            if(numbers[i]>numberOnIndex){
                index =i;
                largeFound=true;
                break;
            }
        }

        if (largeFound){
            return index;
        }else {

            return -1;
        }

    }


    private static int getNextSmaller(int indexOfStart){

        long numberOnIndex = numbers[indexOfStart];
        int index=0;
        boolean largeFound=false;

        for (int i = indexOfStart; i <numbers.length ; i++) {

            if(numbers[i]<numberOnIndex){
                index =i;
                largeFound=true;
                break;
            }
        }

        if (largeFound){
            return index;
        }else {
            return -1;
        }

    }


}
