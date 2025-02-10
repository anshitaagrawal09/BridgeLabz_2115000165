
import java.util.ArrayList;
import java.util.List;
abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;

    //Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    //Getters
    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
    //Setters
    public void setEmployeeId(){
        this.employeeId=employeeId;
    }
    public void setName(){
        this.name = name;
    }
    public void setBaseSalary(){
        this.baseSalary=baseSalary;
    }
    // Abstract method for salary calculation
    public abstract double calculateSalary();

    // Concrete method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

interface Department{
    void assignDepartment(String department);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department{
    private double fixedSalary;
    private String department;
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary){
        super(employeeId,name,baseSalary);
        this.fixedSalary=fixedSalary;
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
class PartTimeEmployee extends Employee implements Department{
    private double fixedSalary;
    private String department;
    public PartTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary){
        super(employeeId,name,baseSalary);
        this.fixedSalary=fixedSalary;
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
public class EmployeeManagementSystem{
    public static void main(String[] args){
        List<Employee> employees=new ArrayList<>();
        FullTimeEmployee emp1 = new FullTimeEmployee(1, "Anshita", 5000, 2000);
        emp1.assignDepartment("HR");
       
        PartTimeEmployee emp2 = new PartTimeEmployee(2, "Palak", 3000, 1000);
        emp2.assignDepartment("IT");

        employees.add(emp1);
        employees.add(emp2);

        for(Employee emp:employees){
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("----------------------------");
        }
    }
}

