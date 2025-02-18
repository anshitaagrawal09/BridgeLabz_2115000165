import java.util.ArrayList;
import java.util.List;
// Step 1: Abstract CourseType class
abstract class CourseType {
    private String courseName;
    public CourseType(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public abstract String getEvaluationMethod();  // Abstract method for evaluation type
    public void displayInfo() {
        System.out.println("Course: " + courseName + " | Evaluation: " + getEvaluationMethod());
    }
}
// Step 2: Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}
// Step 3: Generic Course Class
class Course<T extends CourseType> {
    private T courseType;
    private String department;
    private int credits;
    public Course(T courseType, String department, int credits) {
        this.courseType = courseType;
        this.department = department;
        this.credits = credits;
    }
    public T getCourseType() {
        return courseType;
    }
    public String getDepartment() {
        return department;
    }
    public int getCredits() {
        return credits;
    }
    public void displayCourseDetails() {
        System.out.println("Department: " + department + " | Credits: " + credits);
        courseType.displayInfo();
    }
}
// Step 4: CourseCatalog to Manage Multiple Courses
class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    public void displayAllCourses() {
        System.out.println("\n=== University Course Catalog ===");
        for (Course<? extends CourseType> course : courses) {
            course.displayCourseDetails();
            System.out.println("--------------------------------");
        }
    }
}
// Step 5: Main Class to Test the System
public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Creating course types
        ExamCourse mathCourse = new ExamCourse("Mathematics 101");
        AssignmentCourse programmingCourse = new AssignmentCourse("Java Programming");
        ResearchCourse physicsResearch = new ResearchCourse("Quantum Mechanics Research");
        // Creating Courses with different departments
        Course<ExamCourse> math = new Course<>(mathCourse, "Mathematics", 3);
        Course<AssignmentCourse> programming = new Course<>(programmingCourse, "Computer Science", 4);
        Course<ResearchCourse> physics = new Course<>(physicsResearch, "Physics", 5);
        // Creating Course Catalog
        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(math);
        catalog.addCourse(programming);
        catalog.addCourse(physics);
        // Display all courses
        catalog.displayAllCourses();
    }
}
