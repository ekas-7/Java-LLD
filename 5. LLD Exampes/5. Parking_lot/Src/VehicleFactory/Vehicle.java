package VehicleFactory;

import PricingStrategy.PricingStrategy;
import CommonEnum.DurationType;

public abstract class Vehicle {
     private String LiscencePlate;
     private String vehicleType;
     private PricingStrategy pricingStrategy;

     public Vehicle(String LiscencePlate, String vehicleType, PricingStrategy pricingStrategy) {
          this.LiscencePlate = LiscencePlate;
          this.vehicleType = vehicleType;
          this.pricingStrategy = pricingStrategy;

     }

     public String getLiscencePlate(){
        return this.LiscencePlate;
     }

     public String getVehicleType(){
        return this.vehicleType;
     }

     public double calculateFee(int duration, DurationType durationType) {
        return pricingStrategy.calculateFee(vehicleType, duration, durationType);
    }
}