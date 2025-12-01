package PricingStrategy;

import CommonEnum.DurationType;

public interface PricingStrategy {
    double calculateFee(String vehicleType, int duration, DurationType durationType);
}
