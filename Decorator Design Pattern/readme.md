# Decorator Design Pattern

The Decorator Design Pattern is a **structural design** pattern that allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects from the same class. It is often used to adhere to the Open/Closed Principle, which states that classes should be open for extension but closed for modification.

## Key Concepts

- **Component Interface**: Defines the interface for objects that can have responsibilities added to them dynamically.
- **Concrete Component**: The class to which additional responsibilities can be attached.
- **Decorator**: Maintains a reference to a component object and defines an interface that conforms to the component's interface.
- **Concrete Decorators**: Add responsibilities to the component.

## Example: Swiggy Food Items

In this example, we demonstrate the Decorator Design Pattern by creating a food ordering system where additional toppings or features can be added to food items dynamically.

### Classes and Interfaces

1. **FoodItem (Interface)**: Defines the methods `getDescription()` and `getCost()`.
2. **Pizza and Burger (Concrete Components)**: Implement the `FoodItem` interface and provide base descriptions and costs.
3. **Decorator (Abstract Class)**: Implements the `FoodItem` interface and contains a reference to a `FoodItem` object.
4. **CheeseDecorator and SauceDecorator (Concrete Decorators)**: Extend the `Decorator` class and add additional behavior (e.g., extra cheese or sauce).

### Code Example

#### FoodItem Interface

```java
public interface FoodItem {
    public String getDescription();
    public double getCost();
}
```

#### Concrete Components

**Pizza.java**

```java
public class Pizza implements FoodItem {
    private String description = "Pizza";
    private double cost = 200.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
```

**Burger.java**

```java
public class Burger implements FoodItem {
    private String description = "Burger";
    private double cost = 150.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
```

#### Abstract Decorator

**Decorator.java**

```java
public abstract class Decorator implements FoodItem {
    protected FoodItem foodItem;

    public Decorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
```

#### Concrete Decorators

**CheeseDecorator.java**

```java
public class CheeseDecorator extends Decorator {
    private String description = "Cheese";
    private double cost;

    public CheeseDecorator(FoodItem foodItem, double cost) {
        super(foodItem);
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra " + description;
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + cost;
    }
}
```

**SauceDecorator.java**

```java
public class SauceDecorator extends Decorator {
    private String description = "Sauce";
    private double cost;

    public SauceDecorator(FoodItem foodItem, double cost) {
        super(foodItem);
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra " + description;
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + cost;
    }
}
```

#### Main Class

**Swiggy.java**
```java
public class Swiggy {
    public static void main(String[] args) {
        FoodItem pizza = new Pizza();
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());

        pizza = new CheeseDecorator(pizza, 50.0);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());

        pizza = new SauceDecorator(pizza, 20.0);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());

        System.out.println("--------------------------------------------------");
        System.out.println("                    Burger");
        System.out.println("--------------------------------------------------");
        FoodItem burger = new Burger();
        System.out.println("Description: " + burger.getDescription());
        System.out.println("Cost: " + burger.getCost());

        burger = new CheeseDecorator(burger, 30.0);
        System.out.println("Description: " + burger.getDescription());
        System.out.println("Cost: " + burger.getCost());
    }
}
```

## Output

```
Description: Pizza
Cost: 200.0
Description: Pizza with extra Cheese
Total Cost: 250.0
Description: Pizza with extra Cheese with extra Sauce
Total Cost: 270.0
--------------------------------------------------
                    Burger
--------------------------------------------------
Description: Burger
Cost: 150.0
Description: Burger with extra Cheese
Cost: 180.0
```

## Advantages

- Promotes code reusability and flexibility.
- Adheres to the Open/Closed Principle.
- Allows dynamic addition of responsibilities to objects.

## Disadvantages

- Can result in a large number of small classes.
- Complex to implement and debug if overused.
