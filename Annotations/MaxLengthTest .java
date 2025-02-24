import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value(); // Maximum length allowed
}

// Step 2: Apply @MaxLength to the User class field
class User {
    @MaxLength(10) // Restrict username to a maximum of 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Step 3: Validate the field length using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 4: Test the validation
public class MaxLengthTest {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alice123"); // Valid username
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("VeryLongUsername123"); // Exceeds max length, should throw exception
            System.out.println("User created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
