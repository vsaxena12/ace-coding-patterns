package org.multiThreading.locks.explicitLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BackAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public synchronized void withdrawal(int amount) {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+ amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdraw "+ amount);
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+" completed withdraw "+ amount);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupted();
                    } finally {
                        lock.unlock();
                    }

                } else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName()+" could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupted();
        }
    }

    public int leftAmount() {
        return balance;
    }
}
