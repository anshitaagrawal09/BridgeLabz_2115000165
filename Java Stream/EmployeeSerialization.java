import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Version control
    private int id;
    private String name;
    private String department;
    private double salary;
    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    // Display employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }
}
public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser"; // Serialized file name
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        // Adding employees to the list
        employees.add(new Employee(101, "Alice", "HR", 55000));
        employees.add(new Employee(102, "Bob", "IT", 70000));
        employees.add(new Employee(103, "Charlie", "Finance", 60000));
        // Serialize employees to a file
        serializeEmployees(employees);
        // Deserialize employees from the file and display
        List<Employee> deserializedEmployees = deserializeEmployees();
        System.out.println("\nDeserialized Employee List:");
        for (Employee emp : deserializedEmployees) {
            emp.display();
        }
    }
    //Method 1: Serialize Employees
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }
    //Method 2: Deserialize Employees
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}
