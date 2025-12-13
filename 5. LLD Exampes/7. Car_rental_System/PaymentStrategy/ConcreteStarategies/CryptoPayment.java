package PaymentStrategy.ConcreteStarategies;

import PaymentStrategy.Payment;

public class CryptoPayment implements Payment {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
        System.out.println("Wallet address: " + walletAddress);
        System.out.println("Payment successful!");
    }
}
