package thoughtWorks.Year_2019;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by sachin on 6/4/19.
 */
public class Freq {

    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
        int k = Integer.parseInt(inpReader.readLine());

        String string=inpReader.readLine();
        HashMap<Character,Integer> freq=new HashMap<>();
        for (char c:string.toCharArray()) {
                if (freq.get(new Character(c))!=null){
                    freq.put(new Character(c),freq.get(new Character(c))+1);
                }else {
                    freq.put(new Character(c),1);
                }
        }

        HashMap<Character,Integer> freqPart=new HashMap<>();
        int counter=0;
        for (char c:string.toCharArray()) {
            if (freqPart.get(new Character(c))!=null){
                freqPart.put(new Character(c),freqPart.get(new Character(c))+1);
            }else {
                freqPart.put(new Character(c),1);
            }

            if (checkFreq(freqPart,freq,k)){

                counter++;
            }

        }

        System.out.println(counter);



    }

    static boolean checkFreq(HashMap<Character,Integer> freqPart,
                             HashMap<Character,Integer> freq,int k){
        String alpha="abcdefghijklmnopqrstuvwxyz";

        int equal=0;
        for (char c:alpha.toCharArray()) {
            if (freq.get(new Character(c))!=null && freqPart.get(new Character(c))!=null)
            if (freq.get(new Character(c))- freqPart.get(new Character(c))
                    == freqPart.get(new Character(c))){
               equal++;
            }
            if (equal == k){
                return true;
            }
        }
        return false;
    }

}
