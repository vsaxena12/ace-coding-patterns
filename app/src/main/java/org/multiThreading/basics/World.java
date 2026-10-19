package org.multiThreading.basics;

public class World extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(0);
            for(int i=0; i<100; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
