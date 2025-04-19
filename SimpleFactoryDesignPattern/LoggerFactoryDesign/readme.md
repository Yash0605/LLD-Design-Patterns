# Simple Factory Design Pattern

The Simple Factory Design Pattern is a **creational design pattern** that provides a **static method** to create and return instances of different classes based on input parameters. It encapsulates the object creation logic, making the code more maintainable and scalable.

## Use Case

In this example, we implement a `LoggerFactory` that creates different types of loggers (`ConsoleLogger` and `FileLogger`) based on the input.

---

## Code Example

### Logger Interface

```java
public interface Logger {
    void log(String message);
}
```

### ConsoleLogger Class

```java
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}
```

### FileLogger Class

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("FileLogger: " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### LoggerFactory Class

```java
public class LoggerFactory {
    public static Logger getLogger(String type) {
        if ("console".equalsIgnoreCase(type)) {
            return new ConsoleLogger();
        } else if ("file".equalsIgnoreCase(type)) {
            return new FileLogger();
        }
        throw new IllegalArgumentException("Unknown logger type: " + type);
    }
}
```

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = LoggerFactory.getLogger("console");
        consoleLogger.log("This is a console log message.");

        Logger fileLogger = LoggerFactory.getLogger("file");
        fileLogger.log("This is a file log message.");
    }
}
```

---

## Advantages

- Simplifies object creation logic.
- Centralizes the instantiation process.
- Makes the code more maintainable and scalable.

## Disadvantages

- Violates the Open/Closed Principle as adding new types requires modifying the factory.
- Can become a God Class if too many types are handled.

---

## How to Run
1. Compile all the `.java` files.
2. Run the `Main` class.
3. Check the console for the `ConsoleLogger` output.
4. Check the `log.txt` file for the `FileLogger` output.

---

## Conclusion
The Simple Factory Design Pattern is a great way to encapsulate object creation logic, especially when dealing with multiple types of objects. However, it should be used judiciously to avoid violating design principles.