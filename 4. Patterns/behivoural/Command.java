public class Command {
    public static void main(String[] args) {
        TV tv = new TV();

        Comm turnOn = new TurnONComm(tv);
        Comm turnOff = new TurnOFFComm(tv);
        Comm changeChannel = new ChangeChannel(tv, "5");
        Comm adjustVolume = new ChangeVolume(tv, "20");

        RemoteControl remote = new RemoteControl();
        remote.setOnComm(turnOn);
        remote.setOffComm(turnOff);
        remote.pressOnButton(); // Turn on the TV
        remote.pressOffButton(); // Turn off the TV
        
        changeChannel.execute(); // Change the channel
        adjustVolume.execute(); // Adjust the volume


    }
}

interface Comm{
    void execute();
}

class TurnONComm implements Comm{
    private TV tv;

    TurnONComm(TV tv){
        this.tv = tv;
    }
    @Override
    public void execute(){
        tv.TurnON();
    }
}
class TurnOFFComm implements Comm {
    private TV tv;

    TurnOFFComm(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute(){
        tv.TurnOFF();
    }
    
}

class ChangeVolume implements Comm {
    private TV tv;
    private String Volume;

    ChangeVolume(TV tv,String Volume){
        this.tv=tv;
        this.Volume = Volume;
    }
    @Override
    public void execute(){
        tv.ChangeVolume(this.Volume);
    }
}
class ChangeChannel implements Comm {
    private TV tv;
    private String Channel;

    ChangeChannel(TV tv,String Channel){
        this.tv=tv;
        this.Channel = Channel;
    }
    @Override
    public void execute(){
        tv.ChangeChannel(this.Channel);
    }
}

class TV{
    public void TurnON(){
        System.out.println("TV ON");
    }
    public void TurnOFF(){
        System.out.println("TV OFF");
    }
    public void ChangeChannel(String Channel){
        System.out.println("Changed Channel to "+ Channel);
    }
    public void ChangeVolume(String Volume){
        System.out.println("Changed Volume to "+ Volume);
    }
}

class RemoteControl {
    private Comm onComm;
    private Comm offComm;
    public void setOnComm(Comm onComm) {
        this.onComm = onComm;
    }
    public void setOffComm(Comm offComm) {
        this.offComm = offComm;
    }
    public void pressOnButton() {
        onComm.execute();
    }
    public void pressOffButton() {
        offComm.execute();
    }
}