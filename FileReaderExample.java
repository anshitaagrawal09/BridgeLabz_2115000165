import java.io.*;
public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to your file path
        try {
            // Create a FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) { // Read line by line
                System.out.println(line);
            }
            // Close the resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
