public class InternationalOrder extends OrderProcessingTemplate {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for international order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making payment for international order.");
    }

    @Override
    protected void generateInvoice() {
        System.out.println("Generating invoice for international order.");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Sending notification for international order.");
    }

}
