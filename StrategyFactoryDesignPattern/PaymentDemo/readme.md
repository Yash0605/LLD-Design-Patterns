# Strategy Design Pattern with Factory Design Pattern

## Overview

The **Strategy Design Pattern** is a behavioral design pattern that enables selecting an algorithm's behavior at runtime. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern promotes the Open/Closed Principle by allowing the behavior of a class to be extended without modifying its code.

The **Factory Design Pattern** is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. It helps in decoupling the instantiation logic from the client code.

In this implementation, the **Strategy Design Pattern** is used to define different payment methods, and the **Factory Design Pattern** is used to create instances of these payment methods dynamically based on the input.

---

## Implementation

### Key Components

1. **Strategy Interface (`IPayment`)**:
   - Defines a common interface for all payment methods.
   - Example:

     ```java
     public interface IPayment {
         void processPayment(double amount);
     }
     ```

2. **Concrete Strategies**:
   - Implement the `IPayment` interface to provide specific payment behaviors.
   - Examples:
     - `CreditCardPayment`:
       ```java
       public class CreditCardPayment implements IPayment {
           @Override
           public void processPayment(double amount) {
               System.out.println("Processing credit card payment of $" + amount);
           }
       }
       ```
     - `PayPalPayment`:
       ```java
       public class PayPalPayment implements IPayment {
           @Override
           public void processPayment(double amount) {
               System.out.println("Processing PayPal payment of $" + amount);
           }
       }
       ```

3. **Context (`PaymentProcessor`)**:
   - Maintains a reference to the current strategy (`IPayment`) and delegates the payment processing to it.
   - Example:
     ```java
     public class PaymentProcessor {
         private IPayment paymentMethod;

         public PaymentProcessor() {
             this.paymentMethod = null;
         }

         public void processPayment(double amount) {
             paymentMethod.processPayment(amount);
         }

         public void setPaymentMethod(String paymentMethodType) {
             if (this.paymentMethod != null) {
                 this.paymentMethod = null;
             }
             this.paymentMethod = PaymentFactory.getPaymentMethod(paymentMethodType);
         }
     }
     ```

4. **Factory (`PaymentFactory`)**:
   - Creates instances of concrete strategies based on the input.
   - Example:
     ```java
     public class PaymentFactory {
         public static IPayment getPaymentMethod(String paymentType) {
             if (paymentType == null) {
                 return null;
             }
             if (paymentType.equalsIgnoreCase("CREDITCARD")) {
                 return new CreditCardPayment();
             } else if (paymentType.equalsIgnoreCase("PAYPAL")) {
                 return new PayPalPayment();
             }
             return null;
         }
     }
     ```

5. **Client (`Main`)**:
   - Demonstrates the usage of the `PaymentProcessor` and dynamically switches between payment methods.
   - Example:
     ```java
     public class Main {
         public static void main(String[] args) {
             PaymentProcessor paymentProcessor = new PaymentProcessor();
             paymentProcessor.setPaymentMethod("CREDITCARD");

             // Process a payment of $100.0
             paymentProcessor.processPayment(100.0);

             // Change the payment method to PayPal
             paymentProcessor.setPaymentMethod("PAYPAL");

             // Process another payment of $50.0
             paymentProcessor.processPayment(50.0);
         }
     }
     ```

---

## How It Works

1. The `Main` class initializes a `PaymentProcessor` object.
2. The `setPaymentMethod` method dynamically sets the payment method using the `PaymentFactory`.
3. The `processPayment` method delegates the payment processing to the currently set strategy (`IPayment`).
4. The `PaymentFactory` creates the appropriate payment method instance (`CreditCardPayment` or `PayPalPayment`) based on the input.

---

## Advantages

- **Flexibility**: New payment methods can be added without modifying existing code.
- **Reusability**: The `PaymentProcessor` and `PaymentFactory` can be reused for other types of strategies.
- **Separation of Concerns**: The logic for creating payment methods is encapsulated in the `PaymentFactory`, while the behavior is encapsulated in the `IPayment` implementations.

---

## Example Output

```
Processing credit card payment of $100.0
Processing PayPal payment of $50.0
```

---

## Conclusion

This implementation demonstrates how the **Strategy Design Pattern** can be combined with the **Factory Design Pattern** to create a flexible and extensible payment processing system. The Strategy pattern allows dynamic behavior selection, while the Factory pattern simplifies object creation.
