public class AmazonOrder {

    public static void main(String[] args) {
        OrderProcessingTemplate localOrder = new LocalOrder();
        localOrder.processOrder();

        System.out.println("===================================");

        OrderProcessingTemplate internationalOrder = new InternationalOrder();
        internationalOrder.processOrder();
    }

}
