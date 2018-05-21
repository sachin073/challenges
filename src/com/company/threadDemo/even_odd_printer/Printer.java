package com.company.threadDemo.even_odd_printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 4/13/18.
 */
public class Printer {

    char[] txt;

    List<String> syncedWritter = new ArrayList<>();

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.txt="1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890".toCharArray();

         Thread t1= new Thread(new Even(printer));
         t1.start();
        Thread t2=new Thread(new Odd(printer));
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println(printer.syncedWritter);


    }


}
