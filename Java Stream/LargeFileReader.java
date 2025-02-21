import java.io.*;
public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Change to your actual file path
        String keyword = "error"; // Word to filter (case insensitive)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains(keyword)) { // Case-insensitive search
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
