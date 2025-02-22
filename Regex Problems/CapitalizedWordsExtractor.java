import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Regex pattern for capitalized words
        String capitalizedWordPattern = "\\b[A-Z][a-z]+\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(capitalizedWordPattern);
        Matcher matcher = pattern.matcher(text);

        // Store all capitalized words
        List<String> capitalizedWords = new ArrayList<>();

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        // Print all extracted words
        if (capitalizedWords.isEmpty()) {
            System.out.println("No capitalized words found.");
        } else {
            System.out.println(String.join(", ", capitalizedWords));
        }
    }
}
