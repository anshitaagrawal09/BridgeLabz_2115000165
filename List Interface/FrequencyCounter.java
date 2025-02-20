import java.util.*;
public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        // Create a map to store frequencies
        Map<String, Integer> frequencyMap = new HashMap<>();
        // Count occurrences
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        // Print the result
        System.out.println("Frequency Map: " + frequencyMap);
    }
}
