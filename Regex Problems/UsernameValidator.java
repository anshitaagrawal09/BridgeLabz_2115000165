import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        String[] testUsernames = {"user_123", "123user", "us", "valid_123", "A_user", "toooolongusername123"};

        for (String username : testUsernames) {
            System.out.println(username + " → " + (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
