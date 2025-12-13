package VehicleFactory;

import CommanEnum.VehicleType;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String registrationNumber, String make, String model, int year,
               VehicleType type, double baseRentalPrice, int numberOfDoors, String fuelType) {
        super(registrationNumber, make, model, year, type, baseRentalPrice);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    @Override
    public double calculateRentalFee(int days) {
        double baseFee = super.calculateRentalFee(days);
        // Add premium for luxury cars
        if (getType() == VehicleType.LUXURY) {
            return baseFee * 1.5;
        } else if (getType() == VehicleType.SUV) {
            return baseFee * 1.3;
        }
        return baseFee;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }
}
