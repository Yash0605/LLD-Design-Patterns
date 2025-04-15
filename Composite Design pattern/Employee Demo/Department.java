import java.util.ArrayList;
import java.util.List;

public class Department extends EmployeeComponent {
    private String name;

    public String getName() {
        return name;
    }

    private String position;
    private double salary;
    private List<EmployeeComponent> employees = new ArrayList<>();

    public Department(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Department: " + name + ", Position: " + position + ", Salary: " + salary);
        for (EmployeeComponent employee : employees) {
            employee.showEmployeeDetails();
        }
    }

    @Override
    public double calculateSalary() {
        // System.out.println("Salary for department " + name + ": " + salary);
        for (EmployeeComponent employee : employees) {
            this.salary += employee.calculateSalary();
        }

        return this.salary;
    }

    public void add(EmployeeComponent employee) {
        employees.add(employee);
    }

    public void remove(EmployeeComponent employee) {
        employees.remove(employee);
    }

}
