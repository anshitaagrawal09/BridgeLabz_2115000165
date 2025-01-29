import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        int choice = getInput("Enter 1 for Addition, 2 for Subtraction, 3 for Multiplication, 4 for Division: ");
        double num1 = getInputDouble("Enter the first number: ");
        double num2 = getInputDouble("Enter the second number: ");
        switch (choice) {
            case 1:
                double sum = add(num1, num2);
                displayResult("The sum is: " + sum);
                break;
            case 2:
                double difference = subtract(num1, num2);
                displayResult("The difference is: " + difference);
                break;
            case 3:
                double product = multiply(num1, num2);
                displayResult("The product is: " + product);
                break;
            case 4:
                if (num2 != 0) {
                    double quotient = divide(num1, num2);
                    displayResult("The quotient is: " + quotient);
                } else {
                    displayResult("Division by zero is not allowed.");
                }
                break;
            default:
                displayResult("Invalid choice.");
                break;
        }
    }
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static double getInputDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        return a / b;
    }
    public static void displayResult(String result) {
        System.out.println(result);
    }
}

