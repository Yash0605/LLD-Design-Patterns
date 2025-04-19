public class PaymentFactory {
    public static IPayment getPaymentMethod(String paymentType) {
        if (paymentType == null) {
            return null;
        }
        if (paymentType.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCardPayment();
        } else if (paymentType.equalsIgnoreCase("PAYPAL")) {
            return new PayPalPayment();
        }
        return null;
    }
}
