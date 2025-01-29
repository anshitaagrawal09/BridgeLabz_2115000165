import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
        int choice = getInput("Enter 1 to convert Fahrenheit to Celsius or 2 to convert Celsius to Fahrenheit: ");
        if (choice == 1) {
            double fahrenheit = getInputDouble("Enter temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            displayResult(fahrenheit + "°F is equal to " + celsius + "°C");
        } else if (choice == 2) {
            double celsius = getInputDouble("Enter temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            displayResult(celsius + "°C is equal to " + fahrenheit + "°F");
        } else {
            System.out.println("Invalid choice.");
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
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static void displayResult(String result) {
        System.out.println(result);
    }
}
