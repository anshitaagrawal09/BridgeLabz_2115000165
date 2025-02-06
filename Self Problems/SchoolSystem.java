
import java.util.ArrayList;
import java.util.List;
// Course class (Many-to-Many Association with Student)
class Course {
    private String courseName;
    private List<Student> enrolledStudents;
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this); // Maintain bidirectional association
    }
    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : enrolledStudents) {
            System.out.println(" - " + s.getName());
        }
    }
}
// Student class (Aggregated by School, Associated with Courses)
class Student {
    private String name;
    private List<Course> courses;
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addCourse(Course course) {
        courses.add(course); // Only called from Course.enrollStudent()
    }
    public void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}
// School class (Aggregates Students)
class School {
    private String schoolName;
    private List<Student> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);//in students list new student is added
    }
    public void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}
// Main class
public class SchoolSystem {
    public static void main(String[] args) {
        // Create School
        School school = new School("Greenwood High");
        // Create Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        // Add Students to School (Aggregation)
        school.addStudent(alice);
        school.addStudent(bob);
        // Create Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        // Enroll Students in Courses (Association)
        math.enrollStudent(alice);
        science.enrollStudent(alice);
        science.enrollStudent(bob);
        // Show School Students
        school.showStudents();
        // Show Courses for Each Student
        alice.showCourses();
        bob.showCourses();
        // Show Enrolled Students in Each Course
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}

