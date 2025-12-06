package Utility;

import Enum.Direction;
import Enum.ElevatorState;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    // Observer
    // req 

    public Elevator(int id ){
        this.id = id;
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.elevatorState = ElevatorState.IDLE;
    }

}
