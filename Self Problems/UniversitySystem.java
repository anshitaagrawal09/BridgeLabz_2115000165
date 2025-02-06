
import java.util.ArrayList;
import java.util.List;
// Faculty class (Aggregation - Exists Independently)
class Faculty {
    private String name;
    public Faculty(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
// Department class (Composition - Exists Only in a University)
class Department {
    private String name;
    public Department(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
// University class (Composition with Departments, Aggregation with Faculty)
class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }
    // Composition - Creating Departments inside University
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }
    // Aggregation - Adding Faculty who exist independently
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    // Display University Details
    public void showUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println(" - " + dept.getName());
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println(" - " + faculty.getName());
        }
    }
}
// Main class
public class UniversitySystem {
    public static void main(String[] args) {
        // Create Faculty Members (Exist Independently)
        Faculty profJohn = new Faculty("Prof. John");
        Faculty profEmma = new Faculty("Prof. Emma");
        // Create University
        University uni = new University("Harvard");
        // Add Departments (Composition - Exist Only in University)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Physics");
        // Add Faculty Members (Aggregation - Independent Existence)
        uni.addFaculty(profJohn);
        uni.addFaculty(profEmma);
        // Display University Details
        uni.showUniversityDetails();
        // Deleting University (Departments are also deleted, but Faculty still exist)
        uni = null; // Now all departments are deleted, but faculty remain.
    }
}

