package parking.model;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final Instant issuedAt;
    private final int level;
    private final int spotNumber;

    public Ticket(Vehicle vehicle, int level, int spotNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.issuedAt = Instant.now();
        this.level = level;
        this.spotNumber = spotNumber;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public Instant getIssuedAt() { return issuedAt; }
    public int getLevel() { return level; }
    public int getSpotNumber() { return spotNumber; }
}
