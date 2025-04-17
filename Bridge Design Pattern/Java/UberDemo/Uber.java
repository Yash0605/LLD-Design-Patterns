public class Uber implements Navigate {
    private NavigationImplementation navigationImplementation;
    private String driverName;

    public Uber(String driverName) {
        this.driverName = driverName;
    }

    public void setNavigationImplementation(NavigationImplementation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void navigate(String source, String destination) {
        System.out.println(this.driverName + " from Uber is ready to pick you up!");
        this.navigationImplementation.navigate(source, destination);
    }

}
