public class Main {
    public static void main(String[] args) {

        // Create a DesktopBuilder instance
        DesktopBuilder desktopBuilder = new HpDesktopBuilder();

        // Create a DesktopDirector instance with the builder
        DesktopDirector director = new DesktopDirector();

        // Construct the desktop
        Desktop hpDesktop = director.constructDesktop(desktopBuilder);

        // Display the details of the constructed desktop
        System.out.println("Hp Desktop Details:");
        hpDesktop.display();
    }
}
