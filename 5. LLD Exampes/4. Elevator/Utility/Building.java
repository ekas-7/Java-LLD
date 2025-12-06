package Utility;

public class Building {
    private String name;
    private int numberOfFloors;
    // private elevatorController elevatorController;

    public Building(String name,int numberOfFloors){
        this.name = name;
        this.numberOfFloors = numberOfFloors;


    }

    public String getName(){
        return this.name;
    }

    public  int getNumberFloors(){
        return this.numberOfFloors;
    }

    
}
