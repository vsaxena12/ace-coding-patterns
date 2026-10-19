package org.multiThreading.basics;

public class Hello {
    public static void main(String[] agrs) throws InterruptedException {
        Thread.currentThread().setPriority(10);
        World world = new World(); //New
        world.start(); //RUNNABLE
        //world.join();

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        t1.start();

        for(int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName());
        }

    }
}
