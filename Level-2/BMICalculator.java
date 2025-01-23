import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in centimeters (cm): ");
        double heightInCm = scanner.nextDouble();
        double heightInMeters = heightInCm / 100; // Convert cm to meters
        double bmi = weight / (heightInMeters * heightInMeters);
        System.out.println("\nYour BMI is: " + String.format("%.2f", bmi));
        if (bmi < 18.4) {
            System.out.println("Weight Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Weight Status: Normal weight");
        } else if (bmi >= 25 && bmi <= 39.9) {
            System.out.println("Weight Status: Overweight");
        } else {
            System.out.println("Weight Status: Obese");
        }
    }
}

