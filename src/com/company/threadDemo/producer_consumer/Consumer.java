package com.company.threadDemo.producer_consumer;

/**
 * Created by fran on 4/12/18.
 */
public class Consumer implements Runnable {

    WareHouse wareHouse;

    Consumer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }


    @Override
    public void run() {

        while(wareHouse.pid <2000) {
            synchronized (wareHouse.product) {

                if (wareHouse.product.size()==0) {
                    try {
                        System.out.println("consumer waiting now ");
                        wareHouse.product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("removed "+wareHouse.product.remove(0));
                    //wareHouse.product.remove(0);
                    wareHouse.product.notifyAll();
                }
            }

        }

        System.out.println("consumer consumed");

    }
}
