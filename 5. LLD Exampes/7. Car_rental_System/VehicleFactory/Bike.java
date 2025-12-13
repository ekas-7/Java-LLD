package VehicleFactory;

import CommanEnum.VehicleType;

public class Bike extends Vehicle {
    private int engineCapacity;
    private boolean hasCarrier;

    public Bike(String registrationNumber, String make, String model, int year,
                double baseRentalPrice, int engineCapacity, boolean hasCarrier) {
        super(registrationNumber, make, model, year, VehicleType.BIKE, baseRentalPrice);
        this.engineCapacity = engineCapacity;
        this.hasCarrier = hasCarrier;
    }

    @Override
    public double calculateRentalFee(int days) {
        double baseFee = super.calculateRentalFee(days);
        // Bikes are generally cheaper
        return baseFee * 0.7;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }
}
