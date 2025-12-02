package VehicleFactory;

import PricingStrategy.PricingStrategy;


public class Car extends Vehicle {
    public Car(String licensePlate, PricingStrategy pricingStrategy) {
        super(licensePlate, "Car", pricingStrategy);
    }

    // Car-specific behavior could go here
}
