import java.util.regex.*;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        // Password must have at least 8 characters, one uppercase letter, and one digit
        String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
