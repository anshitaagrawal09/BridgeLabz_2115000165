
import java.util.ArrayList;
import java.util.List;
// Employee class (Exists only inside a Department)
class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
// Department class (Exists only inside a Company)
class Department {
    private String name;
    private List<Employee> employees;
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }
    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println(" - Employee: " + e.getName());
        }
    }
}
// Company class (Owns all Departments)
class Company {
    private String name;
    private List<Department> departments;
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }
    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                dept.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }
    public void showCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
        }
    }
}
// Main class
public class CompanySystem {
    public static void main(String[] args) {
        Company myCompany = new Company("TechCorp");
        // Adding departments
        myCompany.addDepartment("IT");
        myCompany.addDepartment("HR");
        // Adding employees to departments
        myCompany.addEmployeeToDepartment("IT", "Alice");
        myCompany.addEmployeeToDepartment("IT", "Bob");
        myCompany.addEmployeeToDepartment("HR", "Charlie");
        // Display company details
        myCompany.showCompanyDetails();
        // When myCompany object is deleted, all its departments and employees are removed automatically (composition)
    }
}

