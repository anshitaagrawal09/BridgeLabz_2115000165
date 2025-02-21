import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "user_info.txt"; // Output file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) { // Append mode
            // Asking user for input
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine()); // Convert to int
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            // Writing data to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.write("------------------------------\n");
            System.out.println("\nUser information saved successfully in '" + fileName + "'!");
        } catch (IOException e) {
            System.out.println("Error reading input or writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input! Please enter a valid number.");
        }
    }
}
