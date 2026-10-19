package org.multiThreading.obseleteCode.synchronization;

public class Counter {
    private int counter = 0;

    public synchronized void increment() {
//        synchronized (this) {
//
//        }
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
