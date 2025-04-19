public class DebugLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new DebugLogger(); // Create and return a DebugLogger instance
    }

}
