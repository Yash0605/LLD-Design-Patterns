public class UberEats implements Navigate {
    private NavigationImplementation navigationImplementation;
    private String deliveryPersonName;

    public UberEats(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public void setNavigationImplementation(NavigationImplementation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void navigate(String source, String destination) {
        System.out.println(this.deliveryPersonName + " from Uber Eats is preparing to navigate...");
        this.navigationImplementation.navigate(source, destination);
    }

}
