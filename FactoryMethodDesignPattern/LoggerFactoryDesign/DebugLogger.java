public class DebugLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("Debug: " + message); // Log debug messages
    }

}
