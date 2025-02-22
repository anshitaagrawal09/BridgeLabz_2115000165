import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        // SSN Pattern: Exactly 3 digits, a hyphen, 2 digits, another hyphen, and 4 digits.
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testSSNs = {
            "123-45-6789", // Valid
            "123456789",   // Invalid (missing hyphens)
            "12-345-6789", // Invalid (wrong format)
            "000-12-3456", // Technically invalid, but format is correct
            "987-65-4321"  // Valid
        };

        for (String ssn : testSSNs) {
            System.out.println(ssn + " is " + (isValidSSN(ssn) ? "Valid " : "Invalid "));
        }
    }
}
