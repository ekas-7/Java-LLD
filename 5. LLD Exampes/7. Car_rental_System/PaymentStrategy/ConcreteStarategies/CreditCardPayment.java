package PaymentStrategy.ConcreteStarategies;

import PaymentStrategy.Payment;

public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card holder: " + cardHolder);
        System.out.println("Card number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment successful!");
    }
}
