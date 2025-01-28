import java.util.Scanner;
public class BMIcalculator {
    public static double findBMI(double weight, double heightInCm) {
        double heightInMeters = heightInCm / 100;
        return weight / (heightInMeters * heightInMeters);
    }
    public static String[] determineBMIStatus(double[] bmiValues) {
        String[] statuses = new String[10];
        for (int i = 0; i < bmiValues.length; i++) {
            if (bmiValues[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmiValues[i] >= 18.5 && bmiValues[i] <= 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmiValues[i] >= 25 && bmiValues[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        double[] bmiValues = new double[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
            bmiValues[i] = findBMI(data[i][0], data[i][1]);
            data[i][2] = bmiValues[i];
        }
        String[] statuses = determineBMIStatus(bmiValues);
        System.out.println("Person | Weight (kg) | Height (cm) | BMI | Status");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%6d | %12.2f | %12.2f | %.2f | %s%n", i + 1, data[i][0], data[i][1], data[i][2], statuses[i]);
        }
        scanner.close();
    }
}

