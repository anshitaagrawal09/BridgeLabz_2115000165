
import java.util.Scanner;
public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        double[][] marks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < 3; j++) {
                while (true) {
                    String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                    System.out.print("Enter " + subject + " marks: ");
                    marks[i][j] = scanner.nextDouble();
                    if (marks[i][j] < 0) {
                        System.out.println("Marks must be positive. Please try again.");
                    } else {
                        break;
                    }
                }
            }
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            }else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        System.out.println("\n--- Student Marks, Percentages, and Grades ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Physics = %.2f, Chemistry = %.2f, Maths = %.2f, Percentage = %.2f%%, Grade = %s%n", (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
        scanner.close();
    }
}

