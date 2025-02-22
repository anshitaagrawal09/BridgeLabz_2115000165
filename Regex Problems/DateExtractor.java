import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Regex pattern for dates in dd/mm/yyyy format
        String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(text);

        // Store extracted dates
        List<String> dates = new ArrayList<>();

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        // Print extracted dates
        if (dates.isEmpty()) {
            System.out.println("No dates found.");
        } else {
            System.out.println(String.join(", ", dates));
        }
    }
}
