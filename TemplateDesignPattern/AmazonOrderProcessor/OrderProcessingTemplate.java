public abstract class OrderProcessingTemplate {
    public void processOrder() {
        selectItem();
        makePayment();
        generateInvoice();
        sendNotification();
    }

    protected abstract void selectItem();

    protected abstract void makePayment();

    protected abstract void generateInvoice();

    protected abstract void sendNotification();
}
