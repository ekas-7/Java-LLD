interface Patient {
    void accept(Visitor visitor);
}

class ChildPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AdultPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class SeniorPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit(SeniorPatient seniorPatient);
}

class DiagnosisVisitor implements Visitor {
    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println(
            "Diagnosing a child patient: Check-up and pediatric care.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println(
            "Diagnosing an adult patient: Routine exams and lifestyle advice.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println(
            "Diagnosing a senior patient: Comprehensive geriatric evaluation.");
    }
}

class BillingVisitor implements Visitor {
    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println("Calculating billing for a child patient.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println("Calculating billing for an adult patient.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println("Calculating billing for a senior patient.");
    }
}

public class Vistor {
    public static void main(String[] args) {
        Patient[] patients = {
            new ChildPatient(), new AdultPatient(), new SeniorPatient()
        };

        Visitor diagnosisVisitor = new DiagnosisVisitor();
        Visitor billingVisitor = new BillingVisitor();

        for (Patient patient : patients) {
            System.out.println("---");
            patient.accept(diagnosisVisitor);
            patient.accept(billingVisitor);
        }
    }
}