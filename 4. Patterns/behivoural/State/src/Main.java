package State.src;

public class Main {
      public static void main(String[] args) {
            TrafficLightContext trafficLight = new TrafficLightContext();
            System.out.println("Initial: " + trafficLight.getColor());
            trafficLight.next(); // RED -> GREEN
            System.out.println("Now: " + trafficLight.getColor());
            trafficLight.next(); // GREEN -> YELLOW
            System.out.println("Now: " + trafficLight.getColor());
            trafficLight.next(); // YELLOW -> RED
            System.out.println("Now: " + trafficLight.getColor());
            trafficLight.next(); // RED -> GREEN
            System.out.println("Now: " + trafficLight.getColor());
      }
}
