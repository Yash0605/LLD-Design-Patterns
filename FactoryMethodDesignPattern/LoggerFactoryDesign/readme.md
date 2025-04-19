# Factory Method Design Pattern

The Factory Method Design Pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. It helps promote loose coupling between client classes and the classes they instantiate.

## Key Concepts

1. **Factory Method**: Defines a method in the superclass for creating objects, but lets subclasses override it to specify the type of object to create.
2. **Product**: The interface or abstract class that defines the type of object the factory method will create.
3. **Concrete Product**: The specific implementation of the product interface.
4. **Creator**: The abstract class or interface that declares the factory method.
5. **Concrete Creator**: Subclasses that implement the factory method to create specific types of products.

## Advantages

- Promotes code reusability and scalability.
- Adheres to the Open/Closed Principle.
- Reduces tight coupling between client and concrete classes.

## Example

```java
// Product Interface
public interface Logger {
    void log(String message);
}

// Concrete Products
public class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("Logging to a file: " + message);
    }
}

public class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("Logging to console: " + message);
    }
}

// Creator
public abstract class LoggerFactory {
    public abstract Logger createLogger();
}

// Concrete Creators
public class FileLoggerFactory extends LoggerFactory {
    public Logger createLogger() {
        return new FileLogger();
    }
}

public class ConsoleLoggerFactory extends LoggerFactory {
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}

// Client
public class Application {
    public static void main(String[] args) {
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger();
        logger.log("Factory Method Design Pattern Example");
    }
}
```

## Difference Between Factory Method and Simple Factory

| Aspect                  | Factory Method                          | Simple Factory                          |
|-------------------------|-----------------------------------------|-----------------------------------------|
| **Definition**          | Relies on inheritance and subclasses to decide which object to create. | Uses a single class with a static method to create objects. |
| **Extensibility**       | Easily extensible by adding new subclasses. | Requires modification of the factory class to add new products. |
| **Design Principle**    | Adheres to the Open/Closed Principle.   | Violates the Open/Closed Principle.     |
| **Complexity**          | More complex due to inheritance.        | Simpler to implement.                   |

## When to Use

- Use the Factory Method when you need to delegate the instantiation logic to subclasses.
- Use the Simple Factory for simpler use cases where extensibility is not a concern.
