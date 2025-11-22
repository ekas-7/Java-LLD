public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2, 0);

        // Simple scenarios
        controller.handleRequest(new Request(0, 5));
        controller.handleRequest(new Request(3, 1));
        controller.handleRequest(new Request(2, 8));

        System.out.println("Final elevator states:");
        for (Elevator e : controller.getElevators()) {
            System.out.println(e);
        }
    }
}
