

import UtiltiyClasses.*;
import VehicleFactory.Vehicle;
import CommanEnum.VehicleType;
import PaymentStrategy.ConcreteStarategies.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   CAR RENTAL SYSTEM DEMONSTRATION");
        System.out.println("========================================\n");

        // Get the singleton instance of RentalService
        RentalService rentalService = RentalService.getInstance();

        // Step 1: Create Rental Stores
        System.out.println("1. Creating Rental Stores...");
        Location downtownLocation = new Location("123 Main St", "New York", "NY", "10001");
        Location airportLocation = new Location("456 Airport Rd", "New York", "NY", "10002");
        
        RentalStore downtownStore = rentalService.addStore("Downtown Store", downtownLocation);
        RentalStore airportStore = rentalService.addStore("Airport Store", airportLocation);
        
        System.out.println("   ✓ Created: " + downtownStore.getName() + " at " + downtownLocation);
        System.out.println("   ✓ Created: " + airportStore.getName() + " at " + airportLocation);
        System.out.println();

        // Step 2: Add Vehicles to Stores
        System.out.println("2. Adding Vehicles to Downtown Store...");
        rentalService.addVehicleToStore(downtownStore.getId(), VehicleType.ECONOMY, 
                                       "ABC123", "Toyota", "Corolla", 2022, 50.0);
        rentalService.addVehicleToStore(downtownStore.getId(), VehicleType.SEDAN, 
                                       "XYZ789", "Honda", "Accord", 2023, 70.0);
        rentalService.addVehicleToStore(downtownStore.getId(), VehicleType.SUV, 
                                       "SUV456", "Ford", "Explorer", 2023, 100.0);
        rentalService.addVehicleToStore(downtownStore.getId(), VehicleType.LUXURY, 
                                       "LUX999", "BMW", "7 Series", 2024, 200.0);
        rentalService.addVehicleToStore(downtownStore.getId(), VehicleType.BIKE, 
                                       "BIKE001", "Yamaha", "R15", 2023, 30.0);
        System.out.println("   ✓ Added 5 vehicles to Downtown Store");
        System.out.println();

        System.out.println("3. Adding Vehicles to Airport Store...");
        rentalService.addVehicleToStore(airportStore.getId(), VehicleType.COMPACT, 
                                       "COM111", "Hyundai", "i20", 2022, 55.0);
        rentalService.addVehicleToStore(airportStore.getId(), VehicleType.VAN, 
                                       "VAN222", "Mercedes", "Sprinter", 2023, 150.0);
        rentalService.addVehicleToStore(airportStore.getId(), VehicleType.TRUCK, 
                                       "TRK333", "Volvo", "FH16", 2022, 180.0);
        System.out.println("   ✓ Added 3 vehicles to Airport Store");
        System.out.println();

        // Step 3: Register Users
        System.out.println("4. Registering Users...");
        User john = rentalService.registerUser("John Doe", "john.doe@email.com");
        User sarah = rentalService.registerUser("Sarah Smith", "sarah.smith@email.com");
        System.out.println("   ✓ Registered: " + john);
        System.out.println("   ✓ Registered: " + sarah);
        System.out.println();

        // Step 4: Search for Available Vehicles
        System.out.println("5. Searching for Available Vehicles...");
        List<Vehicle> availableSUVs = rentalService.searchAvailableVehicles(downtownStore.getId(), VehicleType.SUV);
        System.out.println("   ✓ Found " + availableSUVs.size() + " SUV(s) at Downtown Store");
        for (Vehicle vehicle : availableSUVs) {
            System.out.println("      - " + vehicle.getRegistrationNumber() + 
                             " (Base rate: $" + vehicle.getBaseRentalPrice() + "/day)");
        }
        System.out.println();

        // Step 5: Create Reservations
        System.out.println("6. Creating Reservations...");
        
        // Create dates for rental
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        Date endDate = calendar.getTime();
        
        Reservation johnReservation = rentalService.createReservation(
                john.getId(), "SUV456", downtownStore.getId(), 
                downtownStore.getId(), startDate, endDate);
        
        if (johnReservation != null) {
            System.out.println("   ✓ Reservation created for " + john.getName());
            System.out.println("      " + johnReservation);
            System.out.println();
        }

        // Step 6: Confirm Reservation with Payment
        System.out.println("7. Processing Payment and Confirming Reservation...");
        CreditCardPayment creditCard = new CreditCardPayment(
                "1234567890123456", "John Doe", "12/25", "123");
        
        boolean paymentSuccess = rentalService.confirmReservation(
                johnReservation.getId(), creditCard);
        
        if (paymentSuccess) {
            System.out.println("   ✓ Reservation confirmed!");
        }
        System.out.println();

        // Step 7: Start Rental
        System.out.println("8. Starting Rental...");
        rentalService.startRental(johnReservation.getId());
        System.out.println();

        // Step 8: Create another reservation for Sarah
        System.out.println("9. Creating Second Reservation (Sarah - Luxury Car)...");
        calendar = Calendar.getInstance();
        Date sarahStart = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        Date sarahEnd = calendar.getTime();
        
        Reservation sarahReservation = rentalService.createReservation(
                sarah.getId(), "LUX999", downtownStore.getId(), 
                airportStore.getId(), sarahStart, sarahEnd);
        
        if (sarahReservation != null) {
            System.out.println("   ✓ Reservation created for " + sarah.getName());
            System.out.println("      " + sarahReservation);
            System.out.println();
        }

        // Step 9: Pay with different payment method
        System.out.println("10. Processing Payment with Crypto...");
        CryptoPayment cryptoPayment = new CryptoPayment("0x742d35Cc6634C0532925a3b844Bc454e4438f44e");
        rentalService.confirmReservation(sarahReservation.getId(), cryptoPayment);
        System.out.println();

        // Step 10: Demonstrate cancellation
        System.out.println("11. Creating and Cancelling a Reservation...");
        Reservation cancelReservation = rentalService.createReservation(
                john.getId(), "ABC123", downtownStore.getId(), 
                downtownStore.getId(), startDate, endDate);
        
        if (cancelReservation != null) {
            System.out.println("   ✓ Reservation created: " + cancelReservation);
            System.out.println("   ⚠ Cancelling reservation...");
            rentalService.cancelReservation(cancelReservation.getId());
        }
        System.out.println();

        // Step 11: Complete rental
        System.out.println("12. Completing John's Rental...");
        rentalService.completeRental(johnReservation.getId());
        System.out.println();

        // Step 12: Show user reservations
        System.out.println("13. Viewing User Reservations...");
        System.out.println("   John's Reservations:");
        List<Reservation> johnReservations = rentalService.getUserReservations(john.getId());
        for (Reservation res : johnReservations) {
            System.out.println("      " + res);
        }
        System.out.println();

        System.out.println("   Sarah's Reservations:");
        List<Reservation> sarahReservations = rentalService.getUserReservations(sarah.getId());
        for (Reservation res : sarahReservations) {
            System.out.println("      " + res);
        }
        System.out.println();

        // Step 13: Show all stores
        System.out.println("14. Listing All Rental Stores...");
        List<RentalStore> allStores = rentalService.getAllStores();
        for (RentalStore store : allStores) {
            System.out.println("   ✓ " + store.getName() + " - " + store.getLocation());
            System.out.println("      Available vehicles: " + store.getAvailableVehicles().size());
        }
        System.out.println();

        System.out.println("========================================");
        System.out.println("   DEMONSTRATION COMPLETED!");
        System.out.println("========================================");
    }
}
