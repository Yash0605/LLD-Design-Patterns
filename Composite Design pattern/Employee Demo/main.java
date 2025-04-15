public class main {

    public static void main(String[] args) {
        // Create employees and teams
        EmployeeComponent employee1 = new Employee("John Doe", "Developer", 50000);
        EmployeeComponent employee2 = new Employee("Jane Smith", "Designer", 60000);

        EmployeeComponent employee3 = new Employee("Mike Johnson", "Manager", 70000);
        EmployeeComponent employee4 = new Employee("Emily Davis", "HR", 55000);

        Team team1 = new Team("Development Team", "Team Lead");
        team1.add(employee1);
        team1.add(employee2);

        Team team2 = new Team("Design Team", "Team Lead");
        team2.add(employee3);
        team2.add(employee4);

        Department department = new Department("IT Department", "Department Head");
        department.add(team1);

        System.out.println("Employee Details:");
        employee1.showEmployeeDetails();
        employee2.showEmployeeDetails();

        System.out.println("\nTeam Details:\n " + team1.getName());
        team1.showEmployeeDetails();

        // System.out.println("\nDepartment Salary:");
        // department.calculateSalary();
        System.out.println("\nDepartment Details:\n " + department.getName());
        System.out.println("Total Salary for " + department.getName() + ": " + department.calculateSalary());
    }
}
