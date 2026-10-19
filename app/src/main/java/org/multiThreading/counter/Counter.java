package org.multiThreading.counter;

public class Counter {
    private int counter = 0;

    /**
     * Intrinsic
     */
    public void increment() {
        synchronized (this){
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

}
