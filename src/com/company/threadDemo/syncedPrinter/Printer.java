package com.company.threadDemo.syncedPrinter;

/**
 * Created by fran on 4/11/18.
 */
public class Printer implements Runnable {

    int toPrint=0;

    int times=0;

    SharedResource sharedResource;

    Printer(SharedResource resource,int times){
        this.sharedResource = resource;
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setToPrint(int toPrint) {
        this.toPrint = toPrint;
    }

    public int getToPrint() {
        return toPrint;
    }

    Printer(int oj){
        this.toPrint=oj;
    }


    @Override
    public void run() {

        while (true) {

            synchronized (sharedResource) {
            if (sharedResource.count==3){
                sharedResource.count=0;
                sharedResource.notifyAll();
            }
                if (times == sharedResource.count){
                    System.out.println(Thread.currentThread().getName()+" Prints > "+sharedResource.count);
                    sharedResource.count++;
                    sharedResource.notifyAll();
                }else {
                    try {
                        sharedResource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        }
    }
}