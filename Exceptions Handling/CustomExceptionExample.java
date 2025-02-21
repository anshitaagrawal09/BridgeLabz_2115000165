import java.util.Scanner;
// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class CustomExceptionExample {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        System.out.println("Access granted!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Take user input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Validate age
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
