package com.company.threadDemo.producer_consumer;

import java.util.List;

/**
 * Created by fran on 4/12/18.
 */
public class Producer implements Runnable{

    WareHouse wareHouse;

    Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }


    @Override
    public void run() {

        while (wareHouse.pid<2000){
            synchronized (wareHouse.product) {

                if (wareHouse.limit < wareHouse.product.size()) {
                    try {
                        System.out.println("producer waiting now ");
                        wareHouse.product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(wareHouse.pid+1+" Added ");
                    wareHouse.product.add(++wareHouse.pid);
                    wareHouse.product.notifyAll();
                }
            }

        }
        System.out.println("producer completed");
    }
}
