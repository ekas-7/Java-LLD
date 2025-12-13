package PaymentStrategy.ConcreteStarategies;

import PaymentStrategy.Payment;

public class DebitCardPayment implements Payment {
    private String cardNumber;
    private String cardHolder;
    private String pin;

    public DebitCardPayment(String cardNumber, String cardHolder, String pin) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.pin = pin;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of $" + amount);
        System.out.println("Card holder: " + cardHolder);
        System.out.println("Card number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment successful!");
    }
}
