package PaymentStrategy.ConcreteStarategies;

import PaymentStrategy.Payment;

public class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        // Logic for cash payment processing would go here
    }
}
