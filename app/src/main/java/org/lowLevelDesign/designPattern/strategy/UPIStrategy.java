package org.lowLevelDesign.designPattern.strategy;

public class UPIStrategy implements PaymentStrategy {

    @Override
    public double pay(double amount) {
        System.out.println("Used UPI");
        return amount;
    }
}
