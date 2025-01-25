
import java.util.Scanner;
public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1));
            while (true) {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Weight must be positive. Please try again.");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("Enter height (m): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Height must be positive. Please try again.");
                } else {
                    break;
                }
            }
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }
        System.out.println("\n--- BMI and Weight Status of Persons ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%n", (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        scanner.close();
    }
}

