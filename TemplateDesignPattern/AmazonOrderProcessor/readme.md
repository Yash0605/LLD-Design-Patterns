# Template Design Pattern

The Template Design Pattern is a **behavioral design pattern** that defines the skeleton of an algorithm in a base class but allows subclasses to override specific steps of the algorithm without changing its structure.

## Key Concepts

- **Template Method**: A method in the base class that defines the sequence of steps in the algorithm. **Subclasses can override specific steps but not the overall structure**.
- **Abstract Methods**: Methods that are declared in the base class but implemented in the subclasses.
- **Hook Methods** (optional): Methods that provide default behavior but can be overridden by subclasses.

## Example: Amazon Order Processing

In this example, we demonstrate the Template Design Pattern using an order processing system for Amazon. The process of handling an order is defined in a base class `OrderProcessingTemplate`, and specific types of orders (local and international) implement the details.

### Classes

1. **OrderProcessingTemplate** (Abstract Class):
   - Defines the `processOrder` method, which outlines the steps for processing an order: selecting an item, making payment, generating an invoice, and sending a notification.
   - Declares abstract methods for each step, which must be implemented by subclasses.

2. **LocalOrder** (Concrete Class):
   - Implements the steps for processing a local order.

3. **InternationalOrder** (Concrete Class):
   - Implements the steps for processing an international order.

4. **AmazonOrder** (Main Class):
   - Demonstrates the usage of the Template Design Pattern by processing both local and international orders.

### Code Walkthrough

#### Abstract Class: `OrderProcessingTemplate`

```java
public abstract class OrderProcessingTemplate {
    public void processOrder() {
        selectItem();
        makePayment();
        generateInvoice();
        sendNotification();
    }

    protected abstract void selectItem();

    protected abstract void makePayment();

    protected abstract void generateInvoice();

    protected abstract void sendNotification();
}
```

#### Concrete Class: `LocalOrder`

```java
public class LocalOrder extends OrderProcessingTemplate {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for local order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making payment for local order.");
    }

    @Override
    protected void generateInvoice() {
        System.out.println("Generating invoice for local order.");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Sending notification for local order.");
    }
}
```

#### Concrete Class: `InternationalOrder`

```java
public class InternationalOrder extends OrderProcessingTemplate {
    @Override
    protected void selectItem() {
        System.out.println("Selecting item for international order.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making payment for international order.");
    }

    @Override
    protected void generateInvoice() {
        System.out.println("Generating invoice for international order.");
    }

    @Override
    protected void sendNotification() {
        System.out.println("Sending notification for international order.");
    }
}
```

#### Main Class: `AmazonOrder`

```java
public class AmazonOrder {

    public static void main(String[] args) {
        OrderProcessingTemplate localOrder = new LocalOrder();
        localOrder.processOrder();

        System.out.println("===================================");

        OrderProcessingTemplate internationalOrder = new InternationalOrder();
        internationalOrder.processOrder();
    }
}
```

### Output

When running the `AmazonOrder` class, the output will be:
```
Selecting item for local order.
Making payment for local order.
Generating invoice for local order.
Sending notification for local order.
===================================
Selecting item for international order.
Making payment for international order.
Generating invoice for international order.
Sending notification for international order.
```

## Benefits of Template Design Pattern

- Promotes code reuse by defining the common structure in a base class.
- Allows flexibility by letting subclasses implement specific steps.
- Ensures consistency in the algorithm's structure.

## Use Cases

- Workflow systems where the overall process is fixed, but individual steps vary.
- Frameworks where the core logic is defined, and users can extend specific behaviors.
