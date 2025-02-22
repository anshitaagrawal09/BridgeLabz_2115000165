import java.util.*;
import java.util.regex.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to match words (case-insensitive)
        String regex = "\\b(\\w+)\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> wordCount = new HashMap<>();
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear more than once
        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}
