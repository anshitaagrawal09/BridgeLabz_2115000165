// Class definition
public class Employee {
    // Attributes
    private String name;
    private int id;
    private double salary;
    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: $" + salary);
    }
    // Main method to test the Employee class
    public static void main(String[] args) {
        // Creating an employee object
        Employee emp1 = new Employee("Alice Johnson", 21, 75000.0);
        // Displaying employee details
        emp1.displayDetails();
    }
}
