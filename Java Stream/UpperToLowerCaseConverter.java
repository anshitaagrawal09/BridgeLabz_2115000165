import java.io.*;
public class UpperToLowerCaseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";    // Source file
        String outputFile = "output.txt";  // Destination file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Preserve original line structure
            }
            System.out.println("File conversion completed! Check '" + outputFile + "'.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
