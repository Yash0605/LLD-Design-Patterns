public class PaymentGatewayManager {
    private static PaymentGatewayManager instance;

    private PaymentGatewayManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized PaymentGatewayManager getInstance() {
        if (instance == null) {
            instance = new PaymentGatewayManager();
        }
        return instance;
    }

    public void processPayment(double amount) {
        // Perform payment processing
        System.out.println("Processing payment of $" + amount + " through the payment gateway.");
    }
}
