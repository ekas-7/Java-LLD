package SmartDevicesAdapter;

import SmartDevices.AirConditioner;
import SmartDevices.SmartDevice;

public class AirConditionerAdapter implements SmartDevice {
    private AirConditioner airConditioner;
    // Constructor
    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void turnON() {
        airConditioner.connectViaBluetooth();
        airConditioner.startCooling();
    }

    @Override
    public void turnOFF() {
        airConditioner.stopCooling();
        airConditioner.disconnectBluetooth();
    }
}