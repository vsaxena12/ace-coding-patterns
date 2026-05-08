package org.lowLevelDesign.designPattern.strategy;

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount) {
        double val = paymentStrategy.pay(amount);
        System.out.println(val);
    }
}
