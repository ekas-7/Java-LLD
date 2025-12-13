package UtiltiyClasses;

import VehicleFactory.Vehicle;
import VehicleFactory.VehicleFactory;
import CommanEnum.VehicleType;
import CommanEnum.VehicleStatus;
import PaymentStrategy.Payment;
import PaymentStrategy.PaymentProcessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RentalService {
    private static RentalService instance;
    private List<RentalStore> stores;
    private List<User> users;
    private List<Reservation> reservations;
    private PaymentProcessor paymentProcessor;
    private int nextReservationId;
    private int nextUserId;
    private int nextStoreId;

    private RentalService() {
        this.stores = new ArrayList<>();
        this.users = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor();
        this.nextReservationId = 1;
        this.nextUserId = 1;
        this.nextStoreId = 1;
    }

    public static synchronized RentalService getInstance() {
        if (instance == null) {
            instance = new RentalService();
        }
        return instance;
    }

    // Store Management
    public RentalStore addStore(String name, Location location) {
        RentalStore store = new RentalStore(nextStoreId++, name, location);
        stores.add(store);
        return store;
    }

    public List<RentalStore> getAllStores() {
        return new ArrayList<>(stores);
    }

    public RentalStore getStoreById(int storeId) {
        return stores.stream()
                .filter(s -> s.getId() == storeId)
                .findFirst()
                .orElse(null);
    }

    // User Management
    public User registerUser(String name, String email) {
        User user = new User(nextUserId++, name, email);
        users.add(user);
        return user;
    }

    public User getUserById(int userId) {
        return users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElse(null);
    }

    // Vehicle Management
    public void addVehicleToStore(int storeId, VehicleType type, String registrationNumber,
                                   String make, String model, int year, double baseRentalPrice) {
        RentalStore store = getStoreById(storeId);
        if (store != null) {
            Vehicle vehicle = VehicleFactory.createVehicle(type, registrationNumber, make, model, year, baseRentalPrice);
            store.addVehicle(vehicle);
        }
    }

    // Search for available vehicles
    public List<Vehicle> searchAvailableVehicles(int storeId, VehicleType type) {
        RentalStore store = getStoreById(storeId);
        if (store == null) {
            return new ArrayList<>();
        }

        return store.getAvailableVehicles().stream()
                .filter(v -> type == null || v.getType() == type)
                .collect(Collectors.toList());
    }

    // Reservation Management
    public Reservation createReservation(int userId, String vehicleRegistration, int pickupStoreId,
                                         int returnStoreId, Date startDate, Date endDate) {
        User user = getUserById(userId);
        RentalStore pickupStore = getStoreById(pickupStoreId);
        RentalStore returnStore = getStoreById(returnStoreId);

        if (user == null || pickupStore == null || returnStore == null) {
            System.out.println("Invalid user or store information");
            return null;
        }

        Vehicle vehicle = findVehicleByRegistration(pickupStoreId, vehicleRegistration);
        if (vehicle == null || vehicle.getStatus() != VehicleStatus.AVAILABLE) {
            System.out.println("Vehicle not available");
            return null;
        }

        Reservation reservation = new Reservation(nextReservationId++, user, vehicle,
                pickupStore, returnStore, startDate, endDate);
        reservations.add(reservation);
        user.addReservation(reservation);

        return reservation;
    }

    public boolean confirmReservation(int reservationId, Payment paymentMethod) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found");
            return false;
        }

        boolean paymentSuccess = paymentProcessor.processPayment(reservation.getTotalAmount(), paymentMethod);
        if (paymentSuccess) {
            reservation.confirmReservation();
            System.out.println("Reservation confirmed! Total amount: $" + reservation.getTotalAmount());
            return true;
        }
        return false;
    }

    public boolean startRental(int reservationId) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found");
            return false;
        }

        reservation.startRental();
        System.out.println("Rental started successfully!");
        return true;
    }

    public boolean completeRental(int reservationId) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found");
            return false;
        }

        reservation.completeRental();
        System.out.println("Rental completed successfully!");
        return true;
    }

    public boolean cancelReservation(int reservationId) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found");
            return false;
        }

        reservation.cancelReservation();
        System.out.println("Reservation cancelled successfully!");
        return true;
    }

    public Reservation getReservationById(int reservationId) {
        return reservations.stream()
                .filter(r -> r.getId() == reservationId)
                .findFirst()
                .orElse(null);
    }

    public List<Reservation> getUserReservations(int userId) {
        return reservations.stream()
                .filter(r -> r.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    private Vehicle findVehicleByRegistration(int storeId, String registrationNumber) {
        RentalStore store = getStoreById(storeId);
        if (store == null) {
            return null;
        }

        return store.getVehicles().stream()
                .filter(v -> v.getRegistrationNumber().equals(registrationNumber))
                .findFirst()
                .orElse(null);
    }
}
