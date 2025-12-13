package UtiltiyClasses;

import VehicleFactory.Vehicle;
import CommanEnum.VehicleStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalStore {
    private int id;
    private String name;
    private Location location;
    private List<Vehicle> vehicles;

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(v -> v.getStatus() == VehicleStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
