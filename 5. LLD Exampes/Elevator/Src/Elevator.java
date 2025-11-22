public class Elevator {
    public enum State { IDLE, MOVING_UP, MOVING_DOWN, DOORS_OPEN }

    private final int id;
    private int currentFloor;
    private State state;

    public Elevator(int id, int startFloor) {
        this.id = id;
        this.currentFloor = startFloor;
        this.state = State.IDLE;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public State getState() { return state; }

    public void moveTo(int targetFloor) {
        if (targetFloor == currentFloor) {
            openDoors();
            return;
        }
        if (targetFloor > currentFloor) {
            state = State.MOVING_UP;
            while (currentFloor < targetFloor) {
                currentFloor++;
                tick();
            }
        } else {
            state = State.MOVING_DOWN;
            while (currentFloor > targetFloor) {
                currentFloor--;
                tick();
            }
        }
        openDoors();
        state = State.IDLE;
    }

    private void tick() {
        // simple simulation delay (no real sleep)
        System.out.println("Elevator " + id + " passing floor " + currentFloor);
    }

    public void openDoors() {
        state = State.DOORS_OPEN;
        System.out.println("Elevator " + id + " doors open at floor " + currentFloor);
    }

    @Override
    public String toString() {
        return "Elevator{" + "id=" + id + ", floor=" + currentFloor + ", state=" + state + '}';
    }
}
