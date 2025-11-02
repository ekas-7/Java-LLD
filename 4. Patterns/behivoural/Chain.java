abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processLeaveRequest(int leaveDays);
}

class Supervisor extends Approver {
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays <= 3) {
            System.out.println("Supervisor approved the leave for " + leaveDays + " days.");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}

class Manager extends Approver {
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays > 3 && leaveDays <= 7) {
            System.out.println("Manager approved the leave for " + leaveDays + " days.");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}

class Director extends Approver {
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays > 7 && leaveDays <= 14) {
            System.out.println("Director approved the leave for " + leaveDays + " days.");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Leave request for " + leaveDays + " days denied. Too many days!");
        }
    }
}

public class Chain {

    private static Approver getChainOfApprovers() {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();

        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);

        return supervisor;
    }

    public static void main(String[] args) {
        Approver approverChain = getChainOfApprovers();

        int leaveDays1 = 2;
        System.out.println("Employee requests " + leaveDays1 + " days of leave.");
        approverChain.processLeaveRequest(leaveDays1);
        System.out.println("---");

        int leaveDays2 = 6;
        System.out.println("Employee requests " + leaveDays2 + " days of leave.");
        approverChain.processLeaveRequest(leaveDays2);
        System.out.println("---");

        int leaveDays3 = 10;
        System.out.println("Employee requests " + leaveDays3 + " days of leave.");
        approverChain.processLeaveRequest(leaveDays3);
        System.out.println("---");

        int leaveDays4 = 15;
        System.out.println("Employee requests " + leaveDays4 + " days of leave.");
        approverChain.processLeaveRequest(leaveDays4);
        System.out.println("---");
    }
}