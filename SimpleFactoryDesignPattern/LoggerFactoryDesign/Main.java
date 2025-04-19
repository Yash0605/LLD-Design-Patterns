public class Main {
    public static void main(String[] args) {
        // Create a logger factory
        // LoggerFactory loggerFactory = new LoggerFactory();

        // Create different types of loggers using the factory
        ILogger infoLogger = LoggerFactory.getLogger(LogLevel.INFO);
        ILogger debugLogger = LoggerFactory.getLogger(LogLevel.DEBUG);

        // Use the loggers to log messages
        infoLogger.log("This is an info message.");
        debugLogger.log("This is a debug message.");
    }
}
