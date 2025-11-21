package parking;

import parking.model.*;
import parking.service.ParkingLotService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLotService service = new ParkingLotService(2, 5); // 2 levels, 5 spots each

        System.out.println("Parking lot created: 2 levels, 5 spots each");

        Vehicle car1 = new Car("KA-01-1234");
        Vehicle bike1 = new Bike("KA-01-7777");
        Vehicle truck1 = new Truck("KA-02-9999");

        Ticket t1 = service.parkVehicle(car1);
        Ticket t2 = service.parkVehicle(bike1);
        Ticket t3 = service.parkVehicle(truck1);

        Thread.sleep(1000); // wait 1s to have different timestamps

        // Try to unpark car1
        if (t1 != null) {
            Receipt r1 = service.unparkVehicle(t1.getTicketId());
            System.out.println("Receipt for " + t1.getVehicle().getLicensePlate() + ": " + r1);
        }

        // Park another car
        Vehicle car2 = new Car("KA-03-5555");
        Ticket t4 = service.parkVehicle(car2);

        // Unpark rest
        if (t2 != null) System.out.println(service.unparkVehicle(t2.getTicketId()));
        if (t3 != null) System.out.println(service.unparkVehicle(t3.getTicketId()));
        if (t4 != null) System.out.println(service.unparkVehicle(t4.getTicketId()));

        System.out.println("Demo complete.");
    }
}
