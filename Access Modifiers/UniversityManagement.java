
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student {
    private String researchTopic;
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);//Parent class constructor call
        this.researchTopic = researchTopic;
    }
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        displayStudentDetails();
        System.out.println("Research Topic: " + researchTopic);
    }
}
public class UniversityManagement {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 3.8);
        PostgraduateStudent pg1 = new PostgraduateStudent(102, "Bob", 3.9, "Artificial Intelligence");
        s1.displayStudentDetails();
        pg1.displayPostgraduateDetails();
    }
}

