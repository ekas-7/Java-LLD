// Vehicle.java - Common Interface
public interface Vehicle {
  void start();
  void stop();
}
// Concrete Classes for Car Brands
public class Honda implements Vehicle {
  public void start() {
    System.out.println("Honda Car is starting");
  }
  public void stop() {
    System.out.println("Honda Car is stopping");
  }
}
public class Toyota implements Vehicle {
  public void start() {
    System.out.println("Toyota Car is starting");
  }
  public void stop() {
    System.out.println("Toyota Car is stopping");
  }
}
public class BMW implements Vehicle {
  public void start() {
    System.out.println("BMW Car is starting");
  }
  public void stop() {
    System.out.println("BMW Car is stopping");
  }
}
// Abstract Factory Interface
public interface VehicleFactory {
  Vehicle createVehicle();
}
// Concrete Factories for Each Car Brand
public class HondaFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new Honda();
  }
}
public class ToyotaFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new Toyota();
  }
}
public class BMWFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new BMW();
  }
}
// Client Code
public class Main {
  public static void main(String[] args) {
    VehicleFactory hondaFactory = new HondaFactory();
    Vehicle honda = hondaFactory.createVehicle();
    honda.start();
    honda.stop();
    VehicleFactory toyotaFactory = new ToyotaFactory();
    Vehicle toyota = toyotaFactory.createVehicle();
    toyota.start();
    toyota.stop();
  }
}
