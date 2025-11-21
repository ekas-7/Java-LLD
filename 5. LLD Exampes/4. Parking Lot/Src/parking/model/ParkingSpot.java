package parking.model;

import java.time.Instant;

public class ParkingSpot {
    private final int level;
    private final int spotNumber;
    private final VehicleSize size;
    private Vehicle currentVehicle;
    private Instant occupiedAt;

    public ParkingSpot(int level, int spotNumber, VehicleSize size) {
        this.level = level;
        this.spotNumber = spotNumber;
        this.size = size;
    }

    public boolean canFitVehicle(Vehicle v) {
        if (currentVehicle != null) return false;
        return v.getSize().ordinal() <= size.ordinal();
    }

    public void park(Vehicle v) {
        this.currentVehicle = v;
        this.occupiedAt = Instant.now();
    }

    public Vehicle unpark() {
        Vehicle v = currentVehicle;
        currentVehicle = null;
        occupiedAt = null;
        return v;
    }

    public boolean isFree() { return currentVehicle == null; }
    public int getLevel() { return level; }
    public int getSpotNumber() { return spotNumber; }
    public VehicleSize getSize() { return size; }
    public Instant getOccupiedAt() { return occupiedAt; }
}
