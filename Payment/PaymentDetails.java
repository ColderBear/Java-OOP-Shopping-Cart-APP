package Payment;
public class PaymentDetails {
    private String cardNumber;
    private String cardHolderName;
    private double amount;

    public PaymentDetails(String cardNumber, String cardHolderName, double amount) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.amount = amount;
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public double getAmount() {
        return amount;
    }
}

