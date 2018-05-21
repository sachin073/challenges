package com.company.threadDemo.syncedPrinter;

/**
 * Created by fran on 4/11/18.
 *
 * I create X threads, each of them prints Y equal digits (getting from constructor, for example "11111", "222222" etc)
 * for Z times in cycle. So the result looks like:
 *
 111111111
 222222222
 333333333
 111111111
 222222222
 333333333


 */
public class PrintController {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        resource.setCount(0);
        new Thread(new Printer(resource,1)).start();
        new Thread(new Printer(resource,2)).start();
        new Thread(new Printer(resource,0)).start();

    }
}
