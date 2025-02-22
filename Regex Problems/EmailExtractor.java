import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details.";

        // Regex pattern for extracting emails
        String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(text);

        // Store all extracted emails
        List<String> emails = new ArrayList<>();

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        // Print all extracted emails
        if (emails.isEmpty()) {
            System.out.println("No email addresses found.");
        } else {
            emails.forEach(System.out::println);
        }
    }
}
