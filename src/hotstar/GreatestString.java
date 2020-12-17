package hotstar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sachin on 7/7/18.
 *
 * You are given a string S and an integer Q. You are allowed to perform at most Q operations on the string.
 * In one operation, you can change any vowel to it's next character
 * (e.g., 'a'->'b', 'e'->'f', 'i'->'j', 'o'->'p', 'u'->'v').
 * Generate the lexicographically greatest string by performing at most Q operations on string S.

 Note- Vowels in English alphabet are- 'a','e','i','o','u'.


 Sample Input
 2
 abcde
 3
 xyzwu
 0

 Sample Output
 bbcdf
 xyzwu

 *
 *
 */


public class GreatestString {

    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            inp = inpReader.readLine();
            int test = Integer.parseInt(inp);
            while (test >0){

                inp = inpReader.readLine();
                char[] input = inp.toCharArray();

                inp = inpReader.readLine();
                int ops =Integer.parseInt(inp);

                List<Character> vovels= new ArrayList(Arrays.asList(
                                                        new Character[]
                                                                {'a','e','i','o','u'}));

                for (int i = 0; i < input.length; i++) {

                    if (ops == 0){
                        break;
                    }

                    if (vovels.contains(input[i])){
                        ops--;
                        input[i]++;
                    }
                }

                System.out.println(input);

                test--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
