package org.multiThreading.locks.explicitLock;

public class Driver {
    public static void main(String[] args) {
         BackAccount backAccount = new BackAccount();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                backAccount.withdrawal(27);
                System.out.println("Amount left: "+backAccount.leftAmount());
            }
        };

        Thread t1 = new Thread(runnable, "thread-1");
        Thread t2 = new Thread(runnable, "thread-2");
        Thread t3 = new Thread(runnable, "thread-3");
        Thread t4 = new Thread(runnable, "thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Original Amount: "+backAccount.leftAmount());

    }
}
