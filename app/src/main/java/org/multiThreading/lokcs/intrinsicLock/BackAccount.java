package org.multiThreading.lokcs.intrinsicLock;

public class BackAccount {

    private int balance = 100;

    public synchronized void withdrawal(int amount) {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+ amount);
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName()+" proceeding with withdraw "+ amount);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+" completed withdraw "+ amount);
        } else {
            System.out.println(Thread.currentThread().getName()+" insufficient balance");
        }
    }

    public int leftAmount() {
        return balance;
    }
}
