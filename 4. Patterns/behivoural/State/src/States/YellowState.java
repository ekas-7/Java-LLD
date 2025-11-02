package State.src.States;

import State.src.TrafficLightContext;
import State.src.TrafficlightState;

public class YellowState implements TrafficlightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from YELLOW to RED. Stop!");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}