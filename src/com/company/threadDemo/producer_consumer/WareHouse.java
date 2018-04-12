package com.company.threadDemo.producer_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 4/12/18.
 */
public class WareHouse {

    List<Integer> product;
    volatile int pid=0;
    int limit = 4;

    WareHouse(List<Integer> product){
        this.product = product;
    }


    public static void main(String[] args) {
        List<Integer> products = new ArrayList<>();
        WareHouse wareHouse = new WareHouse(products);

        new Thread(new Producer(wareHouse)).start();
        new Thread(new Consumer(wareHouse)).start();

    }

}
