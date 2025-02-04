
public class Employee{
    private static String companyName="Capgemini";
    private static int totalEmployees=0;
    private final int id;
    private String name;
    private String designation;

    // Constructor
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increment total employee count
    }

    public static void displayTotalEmployees(){
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details with instanceof check
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + this.name);
            System.out.println("Employee ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob", 102, "Project Manager");

        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();

        // Display total employees
        Employee.displayTotalEmployees();
    }

}

