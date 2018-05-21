package com.company.threadDemo.even_odd_printer;

/**
 * Created by fran on 4/13/18.
 */
public class Even implements Runnable {


    Printer input;

    Even(Printer txt){
        input = txt;
    }



    @Override
    public void run() {

        for (char chr: input.txt) {

            if (chr%2 == 0){
                System.out.println(" Even removing - "+chr +" and adding to a list");
            }
            synchronized (input.syncedWritter){
                input.syncedWritter.add(chr+"");
            }

        }
    }
}
