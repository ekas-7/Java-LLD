package CommandPattern.ConcreteClasses;

import CommandPattern.ElevatorCommand;
import Enum.Direction;
import Utility.ElevatorController;

public class ElevatorRequest implements ElevatorCommand {
    private int elevatorId;
    private int floor;
    private Direction requestDirection;
    private boolean isInternalRequest;
    private ElevatorController controller;

    // private ElevatorController controller;

    public ElevatorRequest(int elevatorId, int floor, Direction direction,
        boolean isInternalRequest
    ){
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.requestDirection = direction;
        this.isInternalRequest = isInternalRequest;
         this.controller = new ElevatorController();
    }

     @Override
    public void execute() {
        // Use the controller's requestElevator method for both internal and external requests.
        // For internal requests the controller can ignore the direction (it may be null).
        controller.requestElevator(elevatorId, floor, requestDirection);
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
