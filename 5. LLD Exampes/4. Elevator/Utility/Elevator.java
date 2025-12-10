package Utility;

import CommandPattern.ConcreteClasses.ElevatorRequest;
import ElevatorObserver.ElevatorObserver;

import Enum.Direction;
import Enum.ElevatorState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private Queue<ElevatorRequest> requests;
    private List<ElevatorObserver> observers;
    // req 

    public Elevator(int id ){
        this.id = id;
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.observers = new ArrayList<ElevatorObserver>();
        this.requests = new LinkedList<ElevatorRequest>();
        // initialize state via notifyStateChange so observers are informed and the method is used
        notifyStateChange(ElevatorState.IDLE);
        notifyFloorChange(currentFloor);
    }

    // List of all getters

    public int getId() {
        return id;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public ElevatorState getState(){
        return this.elevatorState;
    }

    public Queue<ElevatorRequest> getRequests(){
        return new LinkedList<>(requests);
    }

    public List<ElevatorRequest> getDestinationFloors(){
        return new ArrayList<>(requests);
    }

    // add and remove observer
    public void addObserver(ElevatorObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer){
        observers.remove(observer);
    }

    private void notifyStateChange(ElevatorState state){
        // Update internal state first, then notify observers
        this.elevatorState = state;
        for(ElevatorObserver observer: observers){
            observer.onElevatorStateChange(this, state);
        }
    }

    private void notifyFloorChange(int floor) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorFloorChange(this, floor);
        }
    }

    //setters
    public void setState(ElevatorState newState){
        this.elevatorState = newState;
        notifyStateChange(newState);
    }
    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    // Add a new floor request to the queue
    public void addRequest(ElevatorRequest elevatorRequest){
        if(!requests.contains(elevatorRequest)){
            requests.add(elevatorRequest);
        }

        int requestedFloor = elevatorRequest.getFloor();

        if(elevatorState == ElevatorState.IDLE && !requests.isEmpty()){
            if(requestedFloor > currentFloor){
                setDirection(Direction.UP);
            }
            else if(requestedFloor < currentFloor){
                setDirection(Direction.DOWN);
            }
            setState(ElevatorState.MOVING);
        }
    }

    // Move the elevatpr to the next stop decided by the scheduling strategy
    public void moveToNextStop(int  nextStop){
        if(elevatorState != ElevatorState.MOVING){
            return;
        }

        while(currentFloor!=nextStop){
            if(direction == Direction.UP){
                currentFloor++;
            }
            else{
                currentFloor--;
            }
        }

        notifyFloorChange(currentFloor);

        if (currentFloor==nextStop){
            completeArrival();
            return;
        }

        
    }
    
    private void completeArrival(){
        setState(ElevatorState.STOPPED);

        requests.removeIf(request -> request.getFloor() == currentFloor);
        // If no more requests, set state to IDLE
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            setState(ElevatorState.IDLE);
        } else {
            // Otherwise, continue moving after a brief stop
            setState(ElevatorState.MOVING);
        }
    }

}
