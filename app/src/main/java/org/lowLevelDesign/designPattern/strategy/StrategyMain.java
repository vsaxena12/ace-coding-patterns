package org.lowLevelDesign.designPattern.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditStrategy());
        cart.checkout(100.00);

        cart.setPaymentStrategy(new UPIStrategy());
        cart.checkout(50.00);

    }
}
