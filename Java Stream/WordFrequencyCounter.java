import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Change this to your file path
        // HashMap to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Normalize text: Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z ]", "");
                // Split line into words
                String[] words = line.split("\\s+");
                // Count occurrences of each word
                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty words
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            // Sort words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            // Display the total word count
            int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total Words: " + totalWords);
            // Display the top 5 most frequent words
            System.out.println("\nTop 5 Most Frequent Words:");
            sortedWords.stream().limit(5).forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
