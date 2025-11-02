package State.src.States;

import State.src.TrafficlightState;
import State.src.TrafficLightContext;

public class RedState implements TrafficlightState{
    private String Color = "Red";

    @Override
    public void next(TrafficLightContext context){
        System.out.println("Switching from RED to GREEN. Cars go!");
        context.setState(new GreenState());
    }

    @Override
    public String getColor(){
        return Color;
    }

}
