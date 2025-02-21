import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample array for demonstration
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            // Taking index input
            System.out.print("Enter the index of the element: ");
            int index = scanner.nextInt();

            try {
                // Trying to access the element at the given index
                int element = numbers[index];

                // Taking divisor input
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();

                try {
                    // Performing division
                    int result = element / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter an integer.");
        } finally {
            scanner.close(); // Closing scanner
        }
    }
}
