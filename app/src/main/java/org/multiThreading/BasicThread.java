package org.multiThreading;

public class BasicThread {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Main Thread: "+Thread.currentThread().getName());

        Test1 test = new Test1();
        Thread t1 = new Thread(test);
        Test2 test2 = new Test2();

        t1.start();
        test2.start();

    }

    public static class Test1 implements Runnable{

        public void run() {
            for(;;) {
                System.out.println(Thread.currentThread().getName());
            }

        }
    }

    public static class Test2 extends Thread{

        @Override
        public void run() {
            for(;;) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
