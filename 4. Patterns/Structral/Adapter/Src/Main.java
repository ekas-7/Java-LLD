import SmartDevices.AirConditioner;
import SmartDevices.SmartDevice;
import SmartDevicesAdapter.AirConditionerAdapter;
import SmartDevices.CoffeeMachine;
import SmartDevicesAdapter.CoffeeMachineAdapter;

public class Main {
    public static void main(String[] args) {
    AirConditioner ac = new AirConditioner();
    SmartDevice acAdapter = new AirConditionerAdapter(ac);

    System.out.println("Turning ON AirConditioner via adapter:");
    acAdapter.turnON();

    System.out.println("Turning OFF AirConditioner via adapter:");
    acAdapter.turnOFF();

    // Now test CoffeeMachine adapter
    CoffeeMachine cm = new CoffeeMachine();
    SmartDevice cmAdapter = new CoffeeMachineAdapter(cm);

    System.out.println("\nTurning ON CoffeeMachine via adapter:");
    cmAdapter.turnON();

    System.out.println("Turning OFF CoffeeMachine via adapter:");
    cmAdapter.turnOFF();
    }
}
