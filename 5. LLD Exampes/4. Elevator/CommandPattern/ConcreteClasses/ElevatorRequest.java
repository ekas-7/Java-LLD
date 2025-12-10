package CommandPattern.ConcreteClasses;

import Enum.Direction;

public class ElevatorRequest {
    private int elevatorId;
    private int floor;
    private Direction requestDirection;
    private boolean isInternalRequest;

    // private ElevatorController controller;

    public ElevatorRequest(int elevatorId, int floor, Direction direction,
        boolean isInternalRequest
    ){
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.requestDirection = direction;
        this.isInternalRequest = isInternalRequest;

    // this.elevatorController = new elevatorController();
    }


    // getters for elevator request 
    public int getFloor(){
        return this.floor;
    }
    public int getId(){
        return this.elevatorId;
    }
    public Direction getRequestDirection(){
        return this.requestDirection;
    }
    public boolean getIsInternalRequest(){
        return this.isInternalRequest;
    }


}
