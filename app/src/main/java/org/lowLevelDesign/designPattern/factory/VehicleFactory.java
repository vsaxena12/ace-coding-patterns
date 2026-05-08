package org.lowLevelDesign.designPattern.factory;

class VehicleFactory {
    public static Vehicle getVehicle(VehicleType type) {
        return switch (type) {
            case CAR -> new Car();
            case BIKE -> new Bike();
            case TRUCK -> new Truck();
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }
}
