public class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);

    }
}