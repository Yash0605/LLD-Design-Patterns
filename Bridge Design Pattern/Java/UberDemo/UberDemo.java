public class UberDemo {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("                Uber Ride");
        System.out.println("-------------------------------------------------");
        // Create a ride using Google Maps
        Uber uberRide = new Uber("John Doe");
        NavigationImplementation googleMaps = new GoogleMaps();
        uberRide.setNavigationImplementation(googleMaps);
        uberRide.navigate("Paradise", "Madhapur");

        System.out.println("-------------------------------------------------");
        System.out.println("                Uber Eats");
        System.out.println("-------------------------------------------------");
        NavigationImplementation appleMaps = new AppleMaps();
        // Create a food delivery using Apple Maps
        UberEats uberEats = new UberEats("Jane Smith");
        uberEats.setNavigationImplementation(appleMaps);
        uberEats.navigate("Banjara Hills", "Jubilee Hills");
    }
}
