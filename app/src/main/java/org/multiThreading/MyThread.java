package org.multiThreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("RUNNING"); //RUNNING
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        System.out.println(thread.getState()); // NEW

        thread.start();
        System.out.println(thread.getState()); // RUNNABLE
        Thread.sleep(100); // ------> SLEEP THE MAIN THREAD
        System.out.println(thread.getState()); // TIMED_WAITING FOR MAIN THREAD
        thread.join(); // thread-0 is terminated, main thread takes over
        System.out.println(thread.getState()); // TERMINATED
    }
}
