package org.lowLevelDesign.designPattern.factory;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive Car");
    }
}
