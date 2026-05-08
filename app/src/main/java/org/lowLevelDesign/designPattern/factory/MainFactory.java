package org.lowLevelDesign.designPattern.factory;

public class MainFactory {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.getVehicle(VehicleType.CAR);
        v1.drive();

        Vehicle v2 = VehicleFactory.getVehicle(VehicleType.BIKE);
        v2.drive();
    }
}
