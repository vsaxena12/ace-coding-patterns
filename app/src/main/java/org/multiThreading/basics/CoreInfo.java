package org.multiThreading.basics;

public class CoreInfo {
    public static void main(String[] args) throws InterruptedException {

        // How many cores Java can use
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores processors: " + cores);

        // Create 3 threads and show which thread runs (OS picks the core)
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is running on OS-assigned core" +
                    " | Java can't tell which core directly");
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

