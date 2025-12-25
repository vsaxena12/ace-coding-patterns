package org.multiThreading.locks.threadCommunication;

import org.multiThreading.synchronization.MyThread;

class SharedResources {
    private int data;
    private boolean hasData;

    public synchronized void producer(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Producer has data: "+data);
        notify();
    }

    public synchronized void consumer() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumer consumes data: "+data);
        notify();
    }
}

//class Producer implements Runnable {
//
//    SharedResources sharedResources;
//
//    public Producer(SharedResources sharedResources) {
//        this.sharedResources = sharedResources;
//    }
//
//    @Override
//    public void run() {
//        for(int i=0; i<10; i++) {
//            sharedResources.producer(i);
//        }
//    }
//}

//class Consumer implements Runnable {
//
//    SharedResources sharedResources;
//
//    public Consumer(SharedResources sharedResources) {
//        this.sharedResources = sharedResources;
//    }
//
//    @Override
//    public void run() {
//        for(int i=0; i<10; i++) {
//            sharedResources.consumer();
//        }
//    }
//}


public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources();

        Thread thread1 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                sharedResources.producer(i);
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                sharedResources.consumer();
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
