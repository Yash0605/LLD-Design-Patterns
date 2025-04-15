import java.util.ArrayList;
import java.util.List;

public class Team extends EmployeeComponent {
    private String name;
    private String position;
    private double salary;
    private List<EmployeeComponent> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Team(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        for (EmployeeComponent employee : employees) {
            employee.showEmployeeDetails();
        }
        // System.out.println("Name: " + name + ", Position: " + position + ", Salary: "
        // + salary);
    }

    @Override
    public double calculateSalary() {
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

    public List<EmployeeComponent> getEmployees() {
        return employees;
    }

}
