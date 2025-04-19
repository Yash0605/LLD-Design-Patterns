public class LoggerFactory {
    public static ILogger getLogger(LogLevel level) {
        if (level == LogLevel.INFO) {
            return new InfoLogger(); // Return an instance of InfoLogger
        } else if (level == LogLevel.DEBUG) {
            return new DebugLogger(); // Return an instance of DebugLogger
        } else if (level == LogLevel.WARNING) {
            return new WarningLogger(); // Return an instance of DebugLogger
        } else {
            throw new IllegalArgumentException("Unknown logger type: " + level); // Handle unknown logger types
        }
    }
}