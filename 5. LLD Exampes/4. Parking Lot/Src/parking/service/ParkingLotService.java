package parking.service;

import parking.model.*;

import java.time.Instant;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotService {
    private final ParkingLot parkingLot;
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLotService(int levels, int spotsPerLevel) {
        this.parkingLot = new ParkingLot(levels, spotsPerLevel);
    }

    public Ticket parkVehicle(Vehicle v) {
        ParkingSpot spot = parkingLot.findSpot(v);
        if (spot == null) {
            System.out.println("No spot available for " + v.getLicensePlate());
            return null;
        }
        spot.park(v);
        Ticket t = new Ticket(v, spot.getLevel(), spot.getSpotNumber());
        activeTickets.put(t.getTicketId(), t);
        System.out.println("Parked " + v.getLicensePlate() + " at level " + spot.getLevel() + " spot " + spot.getSpotNumber());
        return t;
    }

    public Receipt unparkVehicle(String ticketId) {
        Ticket t = activeTickets.remove(ticketId);
        if (t == null) {
            System.out.println("Invalid ticket: " + ticketId);
            return null;
        }

        // find the spot object
        for (Level l : parkingLot.getLevels()) {
            for (ParkingSpot s : l.getSpots()) {
                if (!s.isFree() && s.getLevel() == t.getLevel() && s.getSpotNumber() == t.getSpotNumber()) {
                    Vehicle v = s.unpark();
                    Instant out = Instant.now();
                    long cents = calculateFee(t.getIssuedAt(), out, v);
                    Receipt r = new Receipt(t.getTicketId(), v.getLicensePlate(), t.getIssuedAt(), out, cents);
                    return r;
                }
            }
        }
        System.out.println("Spot for ticket not found (already freed?)");
        return null;
    }

    private long calculateFee(Instant in, Instant out, Vehicle v) {
        long minutes = Math.max(1, Duration.between(in, out).toMinutes());
        // simple rates: per hour; bike 50c/hr, car 150c/hr, truck 300c/hr
        long ratePerHourCents = 150;
        switch (v.getSize()) {
            case MOTORBIKE: ratePerHourCents = 50; break;
            case COMPACT: ratePerHourCents = 150; break;
            case LARGE: ratePerHourCents = 300; break;
        }
        long hours = (minutes + 59) / 60; // round up
        return hours * ratePerHourCents;
    }
}
