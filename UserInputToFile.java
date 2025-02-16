import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // File to write user input
        try (
            // Step 1: Read input from console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // Step 2: Write to a file
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");
            String userInput;
            while (true) {
                userInput = bufferedReader.readLine(); // Read input line
                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Stop when user enters 'exit'
                }
                bufferedWriter.write(userInput); // Write input to file
                bufferedWriter.newLine(); // Move to next line
            }
            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
