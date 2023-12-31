package Payment;

public class PaymentProcessor {

    public boolean processPayment(PaymentDetails paymentDetails) {

        // In simulation: payments with even-ending card numbers are successful
        return paymentDetails.getCardNumber().endsWith("0") || paymentDetails.getCardNumber().endsWith("2") 
            || paymentDetails.getCardNumber().endsWith("4") || paymentDetails.getCardNumber().endsWith("6") 
            || paymentDetails.getCardNumber().endsWith("8");
    }
}

