interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car Starts");
    }
    public void stop() {
        System.out.println("Car Stops");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike Starts");
    }
    public void stop() {
        System.out.println("Bike Stops");
    }
}

class Vehiclefactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        } else if (vehicleType.equals("Bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

public class factory {
    public static void main(String[] args) {
        Vehicle vehicle1 = Vehiclefactory.getVehicle("Car");
        vehicle1.start();
        vehicle1.stop();
        Vehicle vehicle3 = Vehiclefactory.getVehicle("Bike");
        vehicle3.start();
        vehicle3.stop();
    }
}
