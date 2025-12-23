package org.multiThreading.lokcs.explicitLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int counter = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            counter++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    readWriteLockExample.increment();
                    System.out.println(Thread.currentThread().getName()+ " read ");
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    readWriteLockExample.getCounter();
                    System.out.println(Thread.currentThread().getName()+ " incremented - "+readWriteLockExample.getCounter());
                }
            }
        };

        Thread t1 = new Thread(writeRunnable);
        Thread t2 = new Thread(readRunnable);
        Thread t3 = new Thread(readRunnable);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Counter: "+readWriteLockExample.getCounter());

    }
}
