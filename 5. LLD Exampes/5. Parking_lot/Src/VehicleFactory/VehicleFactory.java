package VehicleFactory;

import PricingStrategy.PricingStrategy;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String licensePlate, PricingStrategy pricingStrategy) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car(licensePlate, pricingStrategy);
            case "bike":
            case "motorbike":
                return new Bike(licensePlate, pricingStrategy);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
