package jan_circuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by sachin on 24/1/18.
 */
public class BuyingItems {


    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {

            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            int sellerCount,items;

            inp = inpReader.readLine();

            sellerCount = Integer.parseInt(inp.split(" ")[0]);
            items = Integer.parseInt(inp.split(" ")[1]);

            String [] sellers = new String[sellerCount];

            long[] sellerPrice = new long[sellerCount];

            for (int i = 0; i < sellerCount; i++) {
                 inp = inpReader.readLine();
                String sellerItms = inp.substring(0,inp.lastIndexOf(" "));
                sellerItms = sellerItms.replaceAll(" ","");
                sellers[i] = sellerItms;
                long c = Long.parseLong(inp.substring(inp.lastIndexOf(" ")+1,inp.length()));
                sellerPrice[i] = c;
            }


            System.out.println(Arrays.toString(sellers));
            System.out.println(Arrays.toString(sellerPrice));

            String[] powerSet =  getPowerSet(sellerCount);

            long [] setSum = new long[1<<sellerCount];

            int x=-1;
            long min=-1;
            for (String sellerSet :powerSet) {
                x++;
                if (sellerSet == null) {
                    continue;
                }

                String[] sellersSet = sellerSet.split(",");  // combination seller range from 0-sellerCount
                String prevSet="",nowSet="";


                for (int i = 0; i < sellersSet.length; i++) {   //0 - 2

                    setSum[x] += sellerPrice[Integer.parseInt(sellersSet[i])];

                    if (i==0){
                            prevSet = sellers[Integer.parseInt(sellersSet[i])];
                            nowSet ="";
                    }else {
                            nowSet = sellers[Integer.parseInt(sellersSet[i])];
                            char[] prevCharArray = prevSet.toCharArray();
                            char[] nowCharArray = nowSet.toCharArray();
                            char[] output = new char[items];
                        for (int j = 0; j < items; j++) {
                            if ('1'==prevCharArray[j] || '1'== nowCharArray[j]) {
                                output[j] = '1';
                            }else {
                                output[j] = '0';
                            }
                        }

                       // prevSet = output.toString();
                        prevSet = String.valueOf(output);
                    }
                }
                if (prevSet.contains("0")){
                    setSum[x] =-1;
                }

                if (setSum[x] !=0 && setSum[x] != -1 && min == -1) {
                    min = setSum[x];
                }

                if (setSum[x] !=0 && setSum[x] != -1 && setSum[x] < min){
                        min = setSum[x];
                }

            }

            System.out.println( Arrays.toString(setSum));

            System.out.println(">> out >"+ min);

            System.out.println(min);

        } catch (IOException  e) {
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e ){
            e.printStackTrace();
        }


    }


     static String[] getPowerSet(int length){

        int[] arr = new int[length];

         for (int i = 0; i < length; i++) {
             arr[i]=i;
         }

         String[] powerSet = new String[1<<length];

         for (int i = 0; i < (1<<length); i++)
         {

             // Print current subset
             for (int j = 0; j < length; j++) {

                 // (1<<j) is a number with jth bit 1
                 // so when we 'and' them with the
                 // subset number we get which numbers
                 // are present in the subset and which
                 // are not
                 if ((i & (1 << j)) > 0) {
                     if (powerSet[i]==null)
                            powerSet[i] = arr[j]+"";
                     else
                        powerSet[i] = powerSet[i]+","+arr[j];
                 }
             }
         }
         //powerSet[0]="-1";
         System.out.println(Arrays.toString(powerSet));

    return powerSet;

     }

}
