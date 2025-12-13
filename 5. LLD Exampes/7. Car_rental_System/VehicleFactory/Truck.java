package VehicleFactory;

import CommanEnum.VehicleType;

public class Truck extends Vehicle {
    private double loadCapacity; // in tons
    private int numberOfAxles;

    public Truck(String registrationNumber, String make, String model, int year,
                 double baseRentalPrice, double loadCapacity, int numberOfAxles) {
        super(registrationNumber, make, model, year, VehicleType.TRUCK, baseRentalPrice);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public double calculateRentalFee(int days) {
        double baseFee = super.calculateRentalFee(days);
        // Trucks are more expensive based on capacity
        return baseFee * (1 + (loadCapacity / 10));
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }
}
