
import java.util.ArrayList;
import java.util.List;
// Course class (Aggregates Students and Professors)
class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();
    Course(String name) {
        this.name = name;
    }
    void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.name + " assigned to " + name);
    }
    void enrollStudent(Student student) {
        students.add(student);
        student.courses.add(this);
        System.out.println(student.name + " enrolled in " + name);
    }
    void showCourseDetails() {
        System.out.println("Course: " + name);
        System.out.println("Professor: " + (professor != null ? professor.name : "None"));
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}
// Student class (Associated with Courses)
class Student {
    String name;
    List<Course> courses = new ArrayList<>();
    Student(String name) {
        this.name = name;
    }
    void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}
// Professor class (Associated with Courses)
class Professor {
    String name;
    Professor(String name) {
        this.name = name;
    }
}
// Main class
public class Main{
    public static void main(String[] args) {
        // Create Courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");
        // Create Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        // Create Professors
        Professor drSmith = new Professor("Dr. Smith");
        // Assign Professor to Course
        math.assignProfessor(drSmith);
        // Students Enroll in Courses
        math.enrollStudent(alice);
        math.enrollStudent(bob);
        cs.enrollStudent(alice);
        // Display Details
        math.showCourseDetails();
        cs.showCourseDetails();
        alice.showEnrolledCourses();
        bob.showEnrolledCourses();
    }
}

