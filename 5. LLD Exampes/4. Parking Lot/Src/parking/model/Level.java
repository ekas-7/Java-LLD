package parking.model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int levelNumber;
    private final List<ParkingSpot> spots = new ArrayList<>();

    public Level(int levelNumber, int spotsPerLevel) {
        this.levelNumber = levelNumber;
        // simple distribution: first spot is large, next two compact, rest motorbike
        for (int i = 0; i < spotsPerLevel; i++) {
            VehicleSize size = VehicleSize.COMPACT;
            if (i == 0) size = VehicleSize.LARGE;
            else if (i >= spotsPerLevel - 2) size = VehicleSize.MOTORBIKE;
            spots.add(new ParkingSpot(levelNumber, i + 1, size));
        }
    }

    public ParkingSpot findSpotForVehicle(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.canFitVehicle(v)) return s;
        }
        return null;
    }

    public List<ParkingSpot> getSpots() { return spots; }
    public int getLevelNumber() { return levelNumber; }
}
