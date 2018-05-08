package com.company.threadDemo.even_odd_printer;

/**
 * Created by fran on 4/13/18.
 */
public class Odd implements Runnable {

    Printer input;

    Odd(Printer txt){
        input = txt;
    }

    @Override
    public void run() {

        for (char chr: input.txt) {

            if (chr%2 != 0){
                System.out.println(" Odd removing - "+chr +" and adding to a list");
            }
            synchronized (input.syncedWritter){
                input.syncedWritter.add(chr+"");
            }

        }

    }
}
