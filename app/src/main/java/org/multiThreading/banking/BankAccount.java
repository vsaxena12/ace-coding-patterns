package org.multiThreading.banking;

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw "+ amount);

    }
}
