package parking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Level> levels = new ArrayList<>();

    public ParkingLot(int numLevels, int spotsPerLevel) {
        for (int i = 0; i < numLevels; i++) {
            levels.add(new Level(i + 1, spotsPerLevel));
        }
    }

    public ParkingSpot findSpot(Vehicle v) {
        for (Level l : levels) {
            ParkingSpot s = l.findSpotForVehicle(v);
            if (s != null) return s;
        }
        return null;
    }

    public List<Level> getLevels() { return levels; }
}
