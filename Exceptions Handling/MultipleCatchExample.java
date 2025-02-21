import java.util.Scanner;
public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Define an example integer array (Uncomment the next line to test NullPointerException)
        Integer[] numbers = {10, 20, 30, 40, 50}; 
        // Integer[] numbers = null; // Uncomment this line to test NullPointerException
        try {
            // Take user input for index
            System.out.print("Enter an index: ");
            int index = scanner.nextInt();

            // Retrieve and print the value at the given index
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index! The index is out of range.");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close scanner
        }
    }
}
