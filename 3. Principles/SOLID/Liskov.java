/ Problematic approach that violates LSP
class Vehicle {
 public
  void startEngine() {
    // Engine starting logic
  }
}

class Car extends Vehicle {
  @Override public void startEngine() {
    // Car-specific engine starting logic
  }
}

class Bicycle extends Vehicle {
  @Override public void startEngine() {
    // Problem: Bicycles don't have engines!
    throw new UnsupportedOperationException("Bicycles don't have engines");
  }
}

public class Main {
 public
  static void main(String[] args) {
    // Creating objects of different subclasses
    Vehicle car = new Car();
    Vehicle bicycle = new Bicycle();
    // Using polymorphism
    System.out.println("Car:");
    car.startEngine();  // Output: Car engine started.
    System.out.println("nBicycle:");
    try {
      bicycle.startEngine();  // Throws UnsupportedOperationException
    } catch (UnsupportedOperationException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
