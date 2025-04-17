public class AppleMaps implements NavigationImplementation {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Navigating from " + source + " to " + destination + " using Apple Maps.");
    }

}
