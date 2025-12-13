package VehicleFactory;

import CommanEnum.VehicleType;

public class VehicleFactory {
    
    public static Vehicle createVehicle(VehicleType type, String registrationNumber,
                                       String make, String model, int year, double baseRentalPrice) {
        switch (type) {
            case ECONOMY:
            case COMPACT:
            case SEDAN:
                return new Car(registrationNumber, make, model, year, type, baseRentalPrice, 4, "Petrol");
            
            case SUV:
                return new Car(registrationNumber, make, model, year, type, baseRentalPrice, 4, "Diesel");
            
            case LUXURY:
                return new Car(registrationNumber, make, model, year, type, baseRentalPrice, 4, "Hybrid");
            
            case VAN:
                return new Car(registrationNumber, make, model, year, type, baseRentalPrice, 5, "Diesel");
            
            case TRUCK:
                return new Truck(registrationNumber, make, model, year, baseRentalPrice, 5.0, 2);
            
            case BIKE:
            case MOTORCYCLE:
                return new Bike(registrationNumber, make, model, year, baseRentalPrice, 150, false);
            
            default:
                return new Vehicle(registrationNumber, make, model, year, type, baseRentalPrice);
        }
    }
}
