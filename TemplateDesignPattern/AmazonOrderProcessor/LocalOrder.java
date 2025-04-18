public class LocalOrder extends OrderProcessingTemplate {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for local order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making payment for local order.");
    }

    @Override
    protected void generateInvoice() {
        System.out.println("Generating invoice for local order.");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Sending notification for local order.");
    }

}
