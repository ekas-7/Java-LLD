package PaymentStrategy;

public class PaymentProcessor {
    public boolean processPayment(double amount, Payment paymentStrategy) {
        paymentStrategy.processPayment(amount);
        return true; // Assume payment is successful for simplicity
    }
}