package VehicleFactory;

import PricingStrategy.PricingStrategy;

public class Bike extends Vehicle {
    public Bike(String licensePlate, PricingStrategy pricingStrategy) {
        super(licensePlate, "Bike", pricingStrategy);
    }

    // Bike-specific behavior could go here
}
