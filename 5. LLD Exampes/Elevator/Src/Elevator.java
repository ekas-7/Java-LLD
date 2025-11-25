public class Elevator {
    public enum State { IDLE, MOVING, DOORS_OPEN }

    private final int id;
    private int currentFloor;
    private State state;
    private Direction currentDirection = Direction.NONE;
    // tickDelayMillis used only for simulation clarity; 0 means no sleep
    private final long tickDelayMillis;

    public Elevator(int id, int startFloor) {
        this(id, startFloor, 0);
    }

    public Elevator(int id, int startFloor, long tickDelayMillis) {
        this.id = id;
        this.currentFloor = startFloor;
        this.state = State.IDLE;
        this.tickDelayMillis = tickDelayMillis;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public State getState() { return state; }
    public Direction getCurrentDirection() { return currentDirection; }

    public void moveTo(int targetFloor) {
        if (targetFloor == currentFloor) {
            openDoors();
            return;
        }

        currentDirection = (targetFloor > currentFloor) ? Direction.UP : Direction.DOWN;
        state = State.MOVING;

        while (currentFloor != targetFloor) {
            currentFloor += (currentDirection == Direction.UP) ? 1 : -1;
            tick();
        }

        openDoors();
        closeDoors();
        state = State.IDLE;
        currentDirection = Direction.NONE;
    }

    private void tick() {
        System.out.println("Elevator " + id + " passing floor " + currentFloor + " (dir=" + currentDirection + ")");
        if (tickDelayMillis > 0) {
            try { Thread.sleep(tickDelayMillis); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        }
    }

    public void openDoors() {
        state = State.DOORS_OPEN;
        System.out.println("Elevator " + id + " doors open at floor " + currentFloor);
    }

    public void closeDoors() {
        System.out.println("Elevator " + id + " doors closed at floor " + currentFloor);
    }

    @Override
    public String toString() {
        return "Elevator{" + "id=" + id + ", floor=" + currentFloor + ", state=" + state + ", dir=" + currentDirection + '}';
    }
}
