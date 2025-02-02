
// Employee class
class Employee {
    public int employeeID;      // public attribute
    protected String department; // protected attribute
    private double salary;      // private attribute
    // Constructor to initialize the employee
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    // Method to modify salary
    public void modifySalary(double newSalary) {
        this.salary = newSalary;
    }
    // Method to get the salary (optional)
    public double getSalary() {
        return this.salary;
    }
}
// Subclass: Manager
class Manager extends Employee {
    // Constructor to initialize the manager
    public Manager(int employeeID, String department, double salary) {
        // Call the parent class constructor
        super(employeeID, department, salary);
    }
    // Method to access employeeID and department
    public String getEmployeeInfo() {
        return "Employee ID: " + employeeID + ", Department: " + department;
    }
}
// EmployeeRecords class to demonstrate the functionality
public class EmployeeRecords{
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee(101, "Engineering", 50000);
        // Modify the salary
        emp.modifySalary(55000);
        System.out.println("Updated salary: " + emp.getSalary());
        // Create a Manager object
        Manager manager = new Manager(102, "Management", 80000);
        // Print employee info using manager
        System.out.println(manager.getEmployeeInfo());
    }
}

