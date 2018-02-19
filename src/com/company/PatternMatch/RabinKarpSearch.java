package com.company.PatternMatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by fran on 2/9/18.
 *
 * Demo link @link http://apprize.info/science/algorithms_2/algorithms_2.files/image197.jpg
 *
 *
 * Hash formula
     hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q
     hash( txt[s .. s+m-1] ) : Hash value at shift s.
     hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
     d: Number of characters in the alphabet
     q: A prime number
     h: d^(m-1)
 *
 *
 *
 * Key takeAway
 *
 * hash is calculated of total window in fixed way. If abc has hash 5 and bac will have 6 or so hash value.
 * 
 *
 */

public class RabinKarpSearch {


    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    static final  int d=256;
    static final int q=11;

    public static void main(String[] args) {


        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            int test= Integer.parseInt(inpReader.readLine());

            String pattern,matcher;
            while (test > 0){

                matcher = inpReader.readLine();
                pattern = inpReader.readLine();

                match(matcher,pattern);

                test--;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static void match(String matcher,String pattern){

        //cal first window hash in pattern

        int hashOfPattern=0;
        int hashOfWindow=0;
        int h=1;
        for (int i = 0; i < pattern.length()-1; i++) {
            h = (h*d) % q;
        }
        System.out.println(h);


            // for first hash cal is  hash= p for each char in p p= noOfChars *p[n-1] + asciiOF(p[i])
        for (int i = 0; i < pattern.length(); i++) {
                hashOfPattern = (hashOfPattern *d + pattern.charAt(i) )%q;
                hashOfWindow = (hashOfWindow *d + matcher.charAt(i) )%q;
        }

        System.out.println( hashOfPattern +" <><>  "+hashOfWindow);


        for (int i = 0; i <= matcher.length()-pattern.length() ; i++) {

            if(hashOfPattern ==hashOfWindow){
                boolean matchFound=true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) !=matcher.charAt(i+j) ){
                        matchFound=false;
                        break;
                    }
                }

                if (matchFound)
                    System.out.println("match found at "+i);
            }

            if ( i < matcher.length()-pattern.length() )
            {
                hashOfWindow = (d*(hashOfWindow - matcher.charAt(i)*h) + matcher.charAt(i+pattern.length()))%q;

                if (hashOfWindow < 0)
                    hashOfWindow = (hashOfWindow + q);
            }
        }
        

    }

}
