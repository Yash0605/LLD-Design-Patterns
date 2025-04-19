public class WarningLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("Warning: " + message); // Log warning messages
    }

}
