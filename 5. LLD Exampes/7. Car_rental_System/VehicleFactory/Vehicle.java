package VehicleFactory;

import CommanEnum.VehicleType;
import CommanEnum.VehicleStatus;

public class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private VehicleType type;
    private VehicleStatus status;
    private double baseRentalPrice;

    public Vehicle(String registrationNumber, String make, String model, 
                   int year, VehicleType type, double baseRentalPrice) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.status = VehicleStatus.AVAILABLE;
        this.baseRentalPrice = baseRentalPrice;
    }

    public double calculateRentalFee(int days) {
        return baseRentalPrice * days;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public double getBaseRentalPrice() {
        return baseRentalPrice;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + registrationNumber + ")";
    }
}
