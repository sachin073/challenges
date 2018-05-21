package niyo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sachin on 10/2/18.
 */
public class Mobile {

    static     String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            int test = Integer.parseInt(inpReader.readLine());

            HashMap<String,HashMap<String,ArrayList<String> >> windowsPhone= new HashMap<>();
            HashMap<String,HashMap<String,ArrayList<String>>> ios= new HashMap<>();
            HashMap<String,HashMap<String,ArrayList<String>>> android= new HashMap<>();

            while (test>0){
                inp = inpReader.readLine();
                String[] inpArr = inp.split(" ");

                //(windows , (2 , (32 , 100 100)))

                if ("windows".equals(inpArr[0])){
                    HashMap ramMatch = windowsPhone.get(inpArr[1]);

                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);

                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;

                            priceList.add(inpArr[3]+"@rating@"+inpArr[4]);
                        }else {
                                storageMatch = new ArrayList();
                                storageMatch.add(inpArr[3]+"@rating@"+inpArr[4]);
                                ramMatch.put(inpArr[2],storageMatch);
                        }
                    }else {

                        ArrayList tempList = new ArrayList();
                        tempList.add(inpArr[3]+"@rating@"+inpArr[4]);

                        HashMap<String,ArrayList<String >> tempMap = new HashMap<>();
                        tempMap.put(inpArr[2],tempList);
                        windowsPhone.put(inpArr[1],tempMap);
                    }


                }else if ("android".equals(inpArr[0])){
                    HashMap ramMatch = android.get(inpArr[1]);

                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);

                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;

                            priceList.add(inpArr[3]+"@rating@"+inpArr[4]);
                        }else {
                            storageMatch = new ArrayList();
                            storageMatch.add(inpArr[3]+"@rating@"+inpArr[4]);
                            ramMatch.put(inpArr[2],storageMatch);
                        }
                    }else {

                        ArrayList tempList = new ArrayList();
                        tempList.add(inpArr[3]+"@rating@"+inpArr[4]);

                        HashMap<String,ArrayList<String >> tempMap = new HashMap<>();
                        tempMap.put(inpArr[2],tempList);
                        android.put(inpArr[1],tempMap);
                    }


                }else if ("ios".equals(inpArr[0])){
                    HashMap ramMatch = ios.get(inpArr[1]);

                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);

                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;

                            priceList.add(inpArr[3]+"@rating@"+inpArr[4]);
                        }else {
                            storageMatch = new ArrayList();
                            storageMatch.add(inpArr[3]+"@rating@"+inpArr[4]);
                            ramMatch.put(inpArr[2],storageMatch);
                        }
                    }else {

                        ArrayList tempList = new ArrayList();
                        tempList.add(inpArr[3]+"@rating@"+inpArr[4]);

                        HashMap<String,ArrayList<String >> tempMap = new HashMap<>();
                        tempMap.put(inpArr[2],tempList);
                        ios.put(inpArr[1],tempMap);
                    }


                }
            test--;
            }

             test = Integer.parseInt(inpReader.readLine());

            while (test>0)   {
                test--;
                inp = inpReader.readLine();
                String[] inpArr = inp.split(" ");

                //(windows , (2 , (32 , 100 100)))
                System.out.println(inp);
                if ("windows".equals(inpArr[0])){
                    HashMap ramMatch = windowsPhone.get(inpArr[1]);

                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);
                        boolean found= false;
                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;
                            int cp= Integer.parseInt(inpArr[3]);

                            double ratingBypriceRatio=-1;
                            String result = null;
                            for (String string: priceList) {
                                int price = Integer.parseInt(string.split("@rating@")[0]);
                                int rating = Integer.parseInt(string.split("@rating@")[1]);
                                if (cp >= price){
                                    double ratio = rating/price;
                                    if (ratingBypriceRatio == -1){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }else if (ratingBypriceRatio < ratio){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }
                                }
                            }
                            if (result !=null){

                                System.out.println(result.split("@rating@")[1]);
                            }else {
                                System.out.println("-1");
                            }
                            continue;
                        }
                    }
                    System.out.println(-1);
                    continue;
                }else if ("android".equals(inpArr[0])){
                    HashMap ramMatch = android.get(inpArr[1]);
                    boolean found = false;
                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);

                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;
                            int cp= Integer.parseInt(inpArr[3]);

                            double ratingBypriceRatio=-1;
                            String result = null;
                            for (String string: priceList) {
                                int price = Integer.parseInt(string.split("@rating@")[0]);
                                int rating = Integer.parseInt(string.split("@rating@")[1]);
                                if (cp >= price){
                                    double ratio = rating/price;
                                    if (ratingBypriceRatio == -1){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }else if (ratingBypriceRatio < ratio){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }
                                }
                            }
                            if (result !=null){

                                System.out.println(result.split("@rating@")[1]);
                            }else {
                                System.out.println("-1");
                            }
                            continue;
                        }
                    }
                    System.out.println(-1);
                    continue;
                }else if ("ios".equals(inpArr[0])){
                    HashMap ramMatch = ios.get(inpArr[1]);
                    boolean found =false;
                    if (ramMatch != null){ // get match ram phone
                        ArrayList storageMatch = (ArrayList) ramMatch.get(inpArr[2]);

                        if (storageMatch !=null){ //get match storage phone

                            ArrayList<String> priceList =storageMatch;
                            int cp= Integer.parseInt(inpArr[3]);

                            double ratingBypriceRatio=-1;
                            String result = null;
                            for (String string: priceList) {
                                int price = Integer.parseInt(string.split("@rating@")[0]);
                                int rating = Integer.parseInt(string.split("@rating@")[1]);
                                if (cp >= price){
                                    double ratio = rating/price;
                                    if (ratingBypriceRatio == -1){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }else if (ratingBypriceRatio < ratio){
                                        ratingBypriceRatio = ratio;
                                        result = string;
                                    }
                                }
                            }
                            if (result !=null){

                                System.out.println(result.split("@rating@")[1]);
                            }else {
                                System.out.println("-1");
                            }
                            continue;
                        }
                    }
                    System.out.println(-1);
                    continue;
                }

            }


            //    System.out.println(windowsPhone);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
