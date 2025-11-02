package State.src;

public interface TrafficlightState {
    void next(TrafficLightContext context);
    String getColor();


}
