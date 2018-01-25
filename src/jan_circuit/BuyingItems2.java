package jan_circuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by fran on 1/25/18.
 */
public class BuyingItems2 {


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

            long[] ratio =  new long[sellerCount];

            for (int i = 0; i < sellerCount; i++) {
                inp = inpReader.readLine();
                String sellerItms = inp.substring(0,inp.lastIndexOf(" "));
                sellerItms = sellerItms.replaceAll(" ","");
                sellers[i] = sellerItms;

                char[] sellersitems = sellerItms.toCharArray();
                int count1 =0;
                for (char item: sellersitems){
                    if (item == '1'){
                        count1++;
                    }
                }

                long c = Long.parseLong(inp.substring(inp.lastIndexOf(" ")+1,inp.length()));
                sellerPrice[i] = c;

                if (count1 !=0) {
                    ratio[i] = c / count1;
                }else {
                    ratio[i] = count1;
                }
            }


            System.out.println(Arrays.toString(sellers));
            System.out.println(Arrays.toString(sellerPrice));
            System.out.println(Arrays.toString(ratio));

        /*    System.out.println( Arrays.toString(setSum));

            System.out.println(">> out >"+ min);

            System.out.println(min);*/

        } catch (IOException e) {
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e ){
            e.printStackTrace();
        }


    }

}
