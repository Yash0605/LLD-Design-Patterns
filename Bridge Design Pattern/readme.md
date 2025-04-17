# Bridge Design Pattern

The Bridge Design Pattern is a structural design pattern that decouples an **abstraction** from its **implementation**, allowing the two to vary independently. This pattern is particularly useful **when you want to avoid a permanent binding between an abstraction and its implementation, enabling flexibility and scalability**.

## Key Components

1. **Abstraction**: Defines the abstraction's interface and maintains a reference to an object of type `Implementor`.
2. **Refined Abstraction**: Extends the abstraction and provides additional functionality.
3. **Implementor**: Defines the interface for implementation classes.
4. **Concrete Implementor**: Implements the `Implementor` interface and provides concrete behavior.

## Example: UberDemo

In this example, the Bridge Design Pattern is used to decouple the navigation functionality from the Uber and Uber Eats services. This allows the navigation implementation (e.g., Google Maps, Apple Maps) to vary independently of the services.

### Components in the Example

1. **Abstraction**: `Navigate` interface
2. **Refined Abstraction**: `Uber` and `UberEats` classes
3. **Implementor**: `NavigationImplementation` interface
4. **Concrete Implementor**: `GoogleMaps` and `AppleMaps` classes

### Code Walkthrough

#### Navigate Interface

Defines the abstraction's interface:

```java

public interface Navigate {
    public void navigate(String source, String destination);
}
```

#### NavigationImplementation Interface

Defines the interface for implementation classes:

```java
public interface NavigationImplementation {
    public void navigate(String source, String destination);
}
```

#### Concrete Implementors

- **GoogleMaps**:

```java
public class GoogleMaps implements NavigationImplementation {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Navigating from " + source + " to " + destination + " using Google Maps.");
    }
}
```

- **AppleMaps**:

```java
public class AppleMaps implements NavigationImplementation {
    @Override
    public void navigate(String source, String destination) {
        System.out.println("Navigating from " + source + " to " + destination + " using Apple Maps.");
    }
}
```

#### Refined Abstractions

- **Uber**:

```java
public class Uber implements Navigate {
    private NavigationImplementation navigationImplementation;
    private String driverName;

    public Uber(String driverName) {
        this.driverName = driverName;
    }

    public void setNavigationImplementation(NavigationImplementation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void navigate(String source, String destination) {
        System.out.println(this.driverName + " from Uber is ready to pick you up!");
        this.navigationImplementation.navigate(source, destination);
    }
}
```

- **UberEats**:

```java
public class UberEats implements Navigate {
    private NavigationImplementation navigationImplementation;
    private String deliveryPersonName;

    public UberEats(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public void setNavigationImplementation(NavigationImplementation navigationImplementation) {
        this.navigationImplementation = navigationImplementation;
    }

    @Override
    public void navigate(String source, String destination) {
        System.out.println(this.deliveryPersonName + " from Uber Eats is preparing to navigate...");
        this.navigationImplementation.navigate(source, destination);
    }
}
```

#### Demo Class

The `UberDemo` class demonstrates the Bridge Design Pattern in action:

```java
public class UberDemo {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("                Uber Ride");
        System.out.println("-------------------------------------------------");
        // Create a ride using Google Maps
        Uber uberRide = new Uber("John Doe");
        NavigationImplementation googleMaps = new GoogleMaps();
        uberRide.setNavigationImplementation(googleMaps);
        uberRide.navigate("Paradise", "Madhapur");

        System.out.println("-------------------------------------------------");
        System.out.println("                Uber Eats");
        System.out.println("-------------------------------------------------");
        NavigationImplementation appleMaps = new AppleMaps();
        // Create a food delivery using Apple Maps
        UberEats uberEats = new UberEats("Jane Smith");
        uberEats.setNavigationImplementation(appleMaps);
        uberEats.navigate("Banjara Hills", "Jubilee Hills");
    }
}
```

### Output

```
-------------------------------------------------
                Uber Ride
-------------------------------------------------
John Doe from Uber is ready to pick you up!
Navigating from Paradise to Madhapur using Google Maps.
-------------------------------------------------
                Uber Eats
-------------------------------------------------
Jane Smith from Uber Eats is preparing to navigate...
Navigating from Banjara Hills to Jubilee Hills using Apple Maps.
```

## Advantages of the Bridge Design Pattern

- Decouples abstraction from implementation.
- Promotes flexibility and scalability.
- Simplifies code maintenance and testing.

## Use Cases

- When you want to avoid a permanent binding between an abstraction and its implementation.
- When both the abstraction and implementation need to be extended independently.
