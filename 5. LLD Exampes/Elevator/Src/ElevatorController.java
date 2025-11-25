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
        // 1) Prefer idle elevator closest to the requested floor
        Optional<Elevator> idleClosest = elevators.stream()
            .filter(e -> e.getState() == Elevator.State.IDLE)
            .min((a, b) -> Integer.compare(Math.abs(a.getCurrentFloor() - floor), Math.abs(b.getCurrentFloor() - floor)));
        if (idleClosest.isPresent()) return idleClosest.get();

        // 2) Prefer elevators that are moving and will pass the requested floor in the correct direction
        Optional<Elevator> passing = elevators.stream()
            .filter(e -> e.getState() == Elevator.State.MOVING)
            .filter(e -> {
                Direction dir = e.getCurrentDirection();
                if (dir == Direction.UP) return e.getCurrentFloor() <= floor;
                if (dir == Direction.DOWN) return e.getCurrentFloor() >= floor;
                return false;
            })
            .min((a, b) -> Integer.compare(Math.abs(a.getCurrentFloor() - floor), Math.abs(b.getCurrentFloor() - floor)));
        if (passing.isPresent()) return passing.get();

        // 3) Fallback: pick the closest elevator regardless of state
        return elevators.stream()
            .min((a, b) -> Integer.compare(Math.abs(a.getCurrentFloor() - floor), Math.abs(b.getCurrentFloor() - floor)))
            .orElse(elevators.get(0));
    }

    public List<Elevator> getElevators() { return elevators; }
}
