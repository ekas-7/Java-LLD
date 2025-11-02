package State.src;

import State.src.States.*;

public class TrafficLightContext {
    private TrafficlightState currentState;

    public TrafficLightContext() {
        currentState = new RedState();
    }

    public void setState(TrafficlightState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public String getColor() {
        return currentState.getColor();
    }
}