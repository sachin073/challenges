package com.company.threadDemo.syncedPrinter;

/**
 * Created by fran on 4/12/18.
 */
public class SharedResource {

    int count=0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
