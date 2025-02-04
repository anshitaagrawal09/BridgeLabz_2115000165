
class Student{
    private static String universityName="GLA";
    private static int totalStudents=0;

    private String name;
    private final int rollNumber;
    private String grade;

    public static void displayTotalStudents(){
        System.out.println("Total Students=>"+totalStudents);
    }

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment total student count
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public void displayGrade() {
        if (this instanceof Student) {
            System.out.println("Grade:"+grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice", 101, "A");
        Student student2 = new Student("Bob", 102, "B");

        student1.displayStudentDetails();
        student2.displayStudentDetails();

        // Update grade
        student1.updateGrade("A+");

        student1.displayGrade();

        // Display updated details
        student1.displayStudentDetails();

        // Display total students
        Student.displayTotalStudents();
    }

}

