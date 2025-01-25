import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        double[] weight = new double[numPersons];
        double[] height = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] weightStatus = new String[numPersons];
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Enter weight (kg): ");
            weight[i] = scanner.nextDouble();
            System.out.print("Enter height (m): ");
            height[i] = scanner.nextDouble();
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] <=39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\n--- BMI and Weight Status of Persons ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%n", (i + 1), height[i], weight[i], bmi[i], weightStatus[i]);
        }
        scanner.close();
    }
}

