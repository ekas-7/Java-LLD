package parking.model;

import java.time.Instant;
import java.time.Duration;

public class Receipt {
    private final String ticketId;
    private final String licensePlate;
    private final Instant inTime;
    private final Instant outTime;
    private final long amountCents;

    public Receipt(String ticketId, String licensePlate, Instant inTime, Instant outTime, long amountCents) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.inTime = inTime;
        this.outTime = outTime;
        this.amountCents = amountCents;
    }

    @Override
    public String toString() {
        long minutes = Duration.between(inTime, outTime).toMinutes();
        return String.format("Receipt[ticket=%s, plate=%s, in=%s, out=%s, minutes=%d, amount=$%.2f]",
                ticketId, licensePlate, inTime, outTime, minutes, amountCents / 100.0);
    }
}
