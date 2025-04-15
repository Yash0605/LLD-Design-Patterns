public class Employee extends EmployeeComponent {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }

    @Override
    public double calculateSalary() {
        return this.salary;
    }

}
