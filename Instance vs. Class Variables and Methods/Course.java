
public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute"; // Common for all courses
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 500);
        Course c2 = new Course("Data Science", 12, 1200);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("Tech Academy");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}

