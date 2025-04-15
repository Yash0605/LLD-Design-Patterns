# Composite Design Pattern - Employee Demo

The **Composite Design Pattern** is a **structural design pattern** that allows you to treat individual objects and compositions of objects uniformly. It is particularly useful when you have a **tree-like structure**, such as a **file system or an organizational hierarchy**.

## Key Components of the Composite Pattern:

1. **Component (Interface or Abstract Class)**:
   - Defines the common interface for all objects in the composition (both leaf and composite).
   - Example: `Employee` interface.

2. **Leaf**:
   - Represents individual objects that do not have children.
   - Example: `Developer` or `Designer` class.

3. **Composite**:
   - Represents objects that have children and can contain other composites or leaves.
   - Example: `Manager` class.

4. **Client**:
   - Interacts with the objects through the `Component` interface, treating both leaves and composites uniformly.

## Example: Employee Demo

### 1. Define the `Employee` Interface (Component)

This interface will define common methods like `getDetails()`.

```java
public interface Employee {
    void showDetails();
}
```

### 2. Create Leaf Classes (Individual Employees)

These represent employees who do not manage others, such as developers or designers.

```java
public class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " works as a " + position);
    }
}
```

```java
public class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " works as a " + position);
    }
}
```

### 3. Create the Composite Class (Manager)

This class can contain other employees (both leaf and composite).

```java
import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println(name + " works as a " + position);
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }
}
```

### 4. Client Code

The client interacts with the `Employee` interface and can treat both individual employees and managers uniformly.

```java
public class Main {
    public static void main(String[] args) {
        // Leaf nodes
        Employee dev1 = new Developer("Alice", "Frontend Developer");
        Employee dev2 = new Developer("Bob", "Backend Developer");
        Employee designer = new Designer("Charlie", "UI/UX Designer");

        // Composite node (Manager)
        Manager manager = new Manager("David", "Project Manager");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.addEmployee(designer);

        // Another composite node (Senior Manager)
        Manager seniorManager = new Manager("Eve", "Senior Manager");
        seniorManager.addEmployee(manager);

        // Display details
        System.out.println("Details of Senior Manager's Team:");
        seniorManager.showDetails();
    }
}
```

## Explanation of the Example:

1. **Leaf Nodes**:
   - `Developer` and `Designer` are individual employees who implement the `Employee` interface.

2. **Composite Node**:
   - `Manager` can manage a list of employees (both leaf and composite).

3. **Client**:
   - The `Main` class interacts with the `Employee` interface, treating both individual employees and managers uniformly.

4. **Output**:
   When you run the `Main` class, it will print the hierarchy of employees, showing how the composite pattern allows you to represent and traverse the organizational structure.

## Advantages of Composite Pattern:

- Simplifies client code by treating individual and composite objects uniformly.
- Makes it easy to add new types of components (e.g., new employee roles).
- Ideal for tree-like structures such as file systems, organizational charts, etc.
