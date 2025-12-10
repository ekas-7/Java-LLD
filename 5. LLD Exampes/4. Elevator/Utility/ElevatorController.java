package Utility;

import SchedulingAlgoStrategy.SchedulingAlgo;
import SchedulingAlgoStrategy.ConcreteSchedulingStrategy.ScanSchedulingAlgo;
import Enum.Direction;

import java.util.List;

import CommandPattern.ConcreteClasses.ElevatorRequest;

import java.util.ArrayList;

public class ElevatorController {
    // List of all elevator in the system
    private List<Elevator> elevators;
    // List of all floors in the system
    private List<Floor>floors;
    // Scheduling strategy 
    private SchedulingAlgo schedulingAlgo;
    // id of curr elevator used for internal operations 
    private int currElevatorId;

    public ElevatorController(){

    }

    public ElevatorController(int numberOfElevators, int numberOfFloors){
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.schedulingAlgo = new ScanSchedulingAlgo();

        for(int i=1;i<=numberOfElevators;i++){
            elevators.add(new Elevator(i));
        }

        for(int i=1;i<=numberOfFloors;i++){
            floors.add(new Floor(i));
        }
    }
    //getters
    public List<Elevator> gElevators(){
        return elevators;
    }

    public List<Floor>getFloors(){
        return floors;
    }

    //setters

    public void setCurrentElevator(int elevatorId){
        this.currElevatorId = elevatorId;
    }
    // Set the scheduling strategy dynamically
    public void setSchedulingStrategy(SchedulingAlgo strategy){
        this.schedulingAlgo = strategy;
    }

    // Handle External Elevator Requests 
    public void requestElevator(int elevatorId,int floorNumber,Direction direction){
        System.out.println(
                "External request: Floor " + floorNumber + ", Direction " + direction);

         Elevator selectedElevator = getElevatorById(elevatorId);
        if (selectedElevator != null) {
            // Add the request to the selected elevator
        // ElevatorRequest constructor is (int elevatorId, int floor, Direction direction, boolean isInternalRequest)
        selectedElevator.addRequest(
            new ElevatorRequest(elevatorId, floorNumber, direction, false));
            System.out.println("Assigned elevator " + selectedElevator.getId()
                    + " to floor " + floorNumber);
        } else {
            // If no suitable elevator is found
            System.out.println("No elevator available for floor " + floorNumber);
        }
    }

}
