package State.src.States;

import State.src.TrafficLightContext;
import State.src.TrafficlightState;

public class GreenState implements TrafficlightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from Green to Yellow. Stop!");
        context.setState(new YellowState());
    }
    @Override
    public String getColor() {
        return "Green";
    }
}