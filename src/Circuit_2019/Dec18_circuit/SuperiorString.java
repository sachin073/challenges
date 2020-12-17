package Circuit_2019.Dec18_circuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sachin on 10/1/19.

 You are given a string  of length . If a string contains at least one character whose frequency is greater than or equal to the half of the length of the string, then the string is called superior.

 You are required to find the length of the longest superior substring available in the given string .

 Inp
 2
 5
 abcde
 14
 ababbbacbcbcca

 Out
 3
 13

 */
public class SuperiorString {


    static String input;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static Map<Character,Integer> cfreq;

    public static void main(String[] args) throws Exception{

        reader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
        int test = Integer.parseInt(reader.readLine());
        while (test>0){

         int length=Integer.parseInt(reader.readLine());
         input = reader.readLine();
         char[] chars = input.toCharArray();
         cfreq = new HashMap<>();
         boolean isSupFound=false;
            calcuateFreq(chars);
            int start=0;
            int end=length-2;
            int currentLength=end-start+1;

            int max =getMaxFreq(cfreq);
            if (max >= length/2){
                System.out.println(length);
                test--;
                continue;
            }

            while (!isSupFound){
             //decrease last char freq
             cfreq.put(chars[currentLength],cfreq.get(new Character(chars[currentLength]))-1);

             Map<Character,Integer> cfreqClone= new HashMap<>(cfreq);

            while (end<length){

                max =getMaxFreq(cfreqClone);
                if (max >= currentLength/2){
                    isSupFound=true;
                    break;
                }
                start++;
                end++;
                if (end<length) {
                    manipulateFreq(cfreqClone, chars[start - 1], chars[end]);
                }
             }
             if (!isSupFound){
                start=0;
                currentLength--;
                end= currentLength-1;
                }
          }
            System.out.println(currentLength);
         test--;
        }

    }

    static void calcuateFreq(char[] chars){

        for (char c :chars) {
            if (cfreq.containsKey(c)){
                cfreq.put(c,cfreq.get(c)+1);
            }else {
                cfreq.put(c,1);
            }
        }
    }

    static void manipulateFreq(Map<Character,Integer> freq ,Character removed ,Character added){
        freq.put(removed,freq.get(removed)-1);
        freq.put(added,freq.get(added)+1);
    }

    static int getMaxFreq(Map<Character,Integer> freqMap){

      return   freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
    }

}