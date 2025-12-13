package PaymentStrategy.ConcreteStarategies;

import PaymentStrategy.Payment;

public class CrptoPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
        // Logic for cash payment processing would go here
    }
}
