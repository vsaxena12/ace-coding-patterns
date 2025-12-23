package org.multiThreading;

public class ThreadMethods extends Thread {

    public ThreadMethods(String name) {
        super(name);
    }

    @Override
    public void run() {
//        System.out.println("Thread is running...");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for(int i=0; i<5; i++) {
//            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority()
//                + " -count: "+ i);
//            Thread.yield();
//            try{
//                Thread.sleep(10000);
//                System.out.println("-----------------------------------------------");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

//        try{
//            Thread.sleep(1000);
//            System.out.println("Thread is running");
//        } catch (InterruptedException e) {
//            System.out.println("Thread Interrupted..."+e);
//        }

        while(true) {
            System.out.println(Thread.currentThread().getName());
        }


    }
    public static void main(String[] args) throws InterruptedException {
//        ThreadMethods t1 = new ThreadMethods();
//        System.out.println(t1.getState());
//
//        t1.start();
//        //Thread.sleep(5000);
//        System.out.println(t1.getState());
//        t1.join();
//        System.out.println(t1.getState());


//        ThreadMethods t2 = new ThreadMethods("Thread-1");
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t2.start();
//
//        ThreadMethods t3 = new ThreadMethods("Thread-2");
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t3.start();
//
//        ThreadMethods t4 = new ThreadMethods("Thread-3");
//        t4.setPriority(Thread.NORM_PRIORITY);
//        t4.start();

//        ThreadMethods t4 = new ThreadMethods("thread-1") ;
//        t4.start();
//        t4.interrupt();

        ThreadMethods t5 = new ThreadMethods("thread-1");
        t5.setDaemon(true);
        t5.start();


    }
}
