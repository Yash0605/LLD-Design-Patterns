public class Main {
    public static void main(String[] args) {
        // Create a logger factory
        ILoggerFactory loggerFactory = new DebugLoggerFactory();
        ILogger debugLogger1 = loggerFactory.createLogger();
        ILogger debugLogger2 = loggerFactory.createLogger();

        debugLogger1.log("This is a debug message from 1.");
        debugLogger2.log("This is a debug message from 2.");

        ILogger infoLogger1 = new InfoLoggerFactory().createLogger();
        infoLogger1.log("This is an info message from 1.");

    }
}
