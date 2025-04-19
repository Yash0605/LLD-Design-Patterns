public class Main {
    public static void main(String[] args) {
        PaymentGatewayManager paymentGateway = PaymentGatewayManager.getInstance();
        paymentGateway.processPayment(100.0);

        PaymentGatewayManager paymentGateway2 = PaymentGatewayManager.getInstance();
        PaymentGatewayManager paymentGateway3 = PaymentGatewayManager.getInstance();

        // check if both instance references are the same
        if (paymentGateway2 == paymentGateway3) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }

        Runnable task = () -> {
            PaymentGatewayManager instance = PaymentGatewayManager.getInstance();
            System.out.println("Instance: " + instance);
        };

        // Create multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        Thread thread5 = new Thread(task);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
