package com.company.PatternMatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by fran on 4/12/18.
 */
public class ClauseFinder {


    public static void main(String[] args) {


        String ask1="UPDATE TBL SET TBL.x=(select * from t2 where x is ..),tbl.y=(select s from TABS) WHERE data is from (select data from x where data is NULL)";
        System.out.println("\n case 1 \n"+ask1);

        System.out.println(    findClause(ask1));

        String ask2="UPDATE TBL SET TBL.x=234,tbl.y=(select s from TABS WHERE x=9) WHERE data is from (select data from x where data is NULL)";

        System.out.println("\n case 2 \n"+ask2);

        System.out.println(    findClause(ask2));


        String ask3="UPDATE TBL SET TBL.x=234 WHERE data is from (select data from x where data is NULL)";
        System.out.println("\n case 3 \n"+ask3);

        System.out.println(    findClause(ask3));


    }



   static String findClause(String string){
        char[] words =  string.toCharArray();
        //string = string.toUpperCase();
        Stack<Integer> opsStack = new Stack();

        int i=0;
        for (char word : words) {

            if (word =='('){
                opsStack.push(i);
            }else if (word==')'){
                opsStack.pop();
            }else if (opsStack.isEmpty()){
                if (word=='W' || word=='w' ){
                    String where = new String(Arrays.copyOfRange(words,i,i+5));
                    if ("WHERE".equalsIgnoreCase(where)){
                        break;
                    }
                }

            }

            i++;
        }
       return string.substring(i);
    }
}
