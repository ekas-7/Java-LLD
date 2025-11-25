public class Main {
    public static void main(String[] args) {
        // Create controller with 2 elevators starting at floor 0.
        // Use a small tick delay so the console simulation is readable.
        Elevator e1 = new Elevator(1, 0, 100);
        Elevator e2 = new Elevator(2, 0, 100);
        ElevatorController controller = new ElevatorController(0, 0);
        // replace internal list with our pre-created elevators for demo simplicity
        controller.getElevators().clear();
        controller.getElevators().add(e1);
        controller.getElevators().add(e2);

        Request[] requests = new Request[] {
            new Request(0, 5),
            new Request(3, 1),
            new Request(2, 8)
        };

        System.out.println("Starting simulation with " + controller.getElevators().size() + " elevators");
        for (Request r : requests) {
            controller.handleRequest(r);
            System.out.println("---");
        }

        System.out.println("Final elevator states:");
        for (Elevator e : controller.getElevators()) {
            System.out.println(e);
        }
    }
}
