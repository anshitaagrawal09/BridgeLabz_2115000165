import java.io.*;
public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to your file path
        String targetWord = "Java"; // Word to count (case-sensitive)
        int wordCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\s+"); // Split by whitespace
                // Count occurrences of the target word
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        wordCount++;
                    }
                }
            }
            // Print the result
            System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
