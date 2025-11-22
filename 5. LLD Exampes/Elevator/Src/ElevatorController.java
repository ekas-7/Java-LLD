import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ElevatorController {
    private final List<Elevator> elevators = new ArrayList<>();

    public ElevatorController(int elevatorCount, int startFloor) {
        for (int i = 0; i < elevatorCount; i++) {
            elevators.add(new Elevator(i + 1, startFloor));
        }
    }

    public void handleRequest(Request req) {
        System.out.println("Handling " + req);
        Elevator chosen = chooseElevator(req.getFromFloor());
        System.out.println("-> chosen: " + chosen);
        chosen.moveTo(req.getFromFloor());
        chosen.moveTo(req.getToFloor());
    }

    private Elevator chooseElevator(int floor) {
        // Very simple policy: pick the idle elevator closest to requested floor,
        // otherwise pick first available.
        Optional<Elevator> best = elevators.stream()
            .filter(e -> e.getState() == Elevator.State.IDLE)
            .min((a, b) -> Integer.compare(Math.abs(a.getCurrentFloor() - floor), Math.abs(b.getCurrentFloor() - floor)));
        if (best.isPresent()) return best.get();
        return elevators.get(0);
    }

    public List<Elevator> getElevators() { return elevators; }
}
