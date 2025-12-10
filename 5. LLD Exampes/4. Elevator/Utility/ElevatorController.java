package Utility;

import SchedulingAlgoStrategy.SchedulingAlgo;

import java.util.List;
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
        // this.schedulingAlgo = 

        for(int i=1;i<=numberOfElevators;i++){
            elevators.add(new Elevator(i));
        }

        for(int i=1;i<=numberOfFloors;i++){
            floors.add(new Floor(i));
        }
    }

    


}
