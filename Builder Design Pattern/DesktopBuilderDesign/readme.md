# Builder Design Pattern

## Overview

The Builder Design Pattern is a **creational design pattern** that allows for the step-by-step construction of complex objects. It separates the construction of an object from its representation, enabling the same construction process to create different representations.

## Why Use the Builder Design Pattern?

When constructing complex objects, the Builder Design Pattern provides a clear and flexible way to create objects with different configurations. It is particularly useful when:

- The construction process involves multiple steps.
- The object being constructed can have different representations or configurations.
- You want to isolate the construction logic from the object itself.

## Example: Desktop Builder

In this example, we demonstrate the Builder Design Pattern by constructing different types of desktops (e.g., HP and Dell) using a step-by-step process.

### Components

1. **Desktop**: The product class that represents the object being built.
2. **DesktopBuilder**: An abstract builder class that defines the steps for building a desktop.
3. **HpDesktopBuilder** and **DellDesktopBuilder**: Concrete builder classes that implement the steps defined in `DesktopBuilder` to create specific types of desktops.
4. **DesktopDirector**: A director class that orchestrates the construction process using a `DesktopBuilder` instance.
5. **Main**: The client class that demonstrates the usage of the Builder Design Pattern.

### Code Explanation

#### Desktop Class

The `Desktop` class represents the product being built. It contains attributes like `cpu`, `ram`, `keyboard`, and `monitor`, along with getter and setter methods.

#### DesktopBuilder Class

The `DesktopBuilder` class is an abstract class that defines the steps for building a desktop. It includes methods like `buildCPU`, `buildRAM`, `buildKeyboard`, and `buildMonitor`. It also contains a `Desktop` instance that is being constructed.

**Why Create the Desktop Instance in DesktopBuilder?**
The `Desktop` instance is created in the `DesktopBuilder` class to:

- Ensure that the construction process is encapsulated within the builder.
- Provide a single point of control for initializing and managing the `Desktop` instance.
- Simplify the client code by abstracting the creation and initialization of the `Desktop` object.

#### HpDesktopBuilder and DellDesktopBuilder Classes

These are concrete builder classes that implement the steps defined in `DesktopBuilder` to create specific types of desktops. For example, `HpDesktopBuilder` sets attributes like `HP CPU`, `HP RAM`, etc., while `DellDesktopBuilder` sets attributes like `Dell CPU`, `Dell RAM`, etc.

#### DesktopDirector Class

The `DesktopDirector` class orchestrates the construction process. It takes a `DesktopBuilder` instance and calls its methods in a specific sequence to construct the desktop.

#### Main Class

The `Main` class demonstrates the usage of the Builder Design Pattern. It creates a `DesktopBuilder` instance (e.g., `HpDesktopBuilder`), passes it to the `DesktopDirector`, and constructs the desktop.

### Code Example

```java
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
```

## Benefits of the Builder Design Pattern

- **Flexibility**: Allows for the construction of different representations of an object using the same process.
- **Encapsulation**: Encapsulates the construction logic within the builder, simplifying the client code.
- **Reusability**: Promotes code reuse by defining a common construction process for different representations.

## Conclusion

The Builder Design Pattern is a powerful tool for constructing complex objects in a step-by-step manner. By separating the construction process from the object itself, it provides flexibility, encapsulation, and reusability. The example of the `DesktopBuilder` demonstrates how this pattern can be applied to create different types of desktops with ease.
