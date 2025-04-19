public class PaymentProcessor {
    private IPayment paymentMethod;

    public PaymentProcessor() {
        this.paymentMethod = null;
    }

    public void processPayment(double amount) {
        paymentMethod.processPayment(amount);
    }

    public void setPaymentMethod(String paymentMethodType) {
        if (this.paymentMethod != null) {
            this.paymentMethod = null;
        }
        this.paymentMethod = PaymentFactory.getPaymentMethod(paymentMethodType);
    }
}
