// Subsystem classes
class CPU {
    void freeze() { System.out.println("Freezing CPU..."); }
    void jump(long position) { System.out.println("Jumping to " + position); }
    void execute() { System.out.println("Executing instructions..."); }
}

class Memory {
    void load(long position, byte[] data) {
        System.out.println("Loading data into memory at " + position);
    }
}

class HardDrive {
    byte[] read(long lba, int size) {
        System.out.println("Reading " + size + " bytes from sector " + lba);
        return new byte[size];
    }
}

// Facade class
class ComputerFacade {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        byte[] bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        cpu.jump(0);
        cpu.execute();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer(); // Simple interface for a complex system
    }
}
