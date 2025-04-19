public class Main {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.setPaymentMethod("CREDITCARD");

        // Process a payment of $100.0
        paymentProcessor.processPayment(100.0);

        // Change the payment method to PayPal
        paymentProcessor.setPaymentMethod("PAYPAL");

        // Process another payment of $50.0
        paymentProcessor.processPayment(50.0);
    }
}
