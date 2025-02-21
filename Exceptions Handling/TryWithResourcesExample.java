import java.io.*;
public class TryWithResourcesExample {
    public static void main(String[] args) {
        String fileName = "info.txt"; // File to read
        // Try-with-resources ensures automatic resource closing
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
