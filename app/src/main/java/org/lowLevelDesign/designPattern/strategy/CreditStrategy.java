package org.lowLevelDesign.designPattern.strategy;

public class CreditStrategy implements PaymentStrategy{

    @Override
    public double pay(double amount) {
        System.out.println("Used CreditCard");
        return amount;
    }
}
