import java.util.regex.*;
import java.util.*;

public class URLExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regex pattern for URLs
        String urlPattern = "https?://[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,})+(?:/[^\\s]*)?";

        // Compile pattern
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(text);

        // Store extracted URLs
        List<String> urls = new ArrayList<>();

        while (matcher.find()) {
            urls.add(matcher.group());
        }

        // Print extracted URLs
        if (urls.isEmpty()) {
            System.out.println("No links found.");
        } else {
            System.out.println(String.join(", ", urls));
        }
    }
}
