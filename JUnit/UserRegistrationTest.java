import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private final UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "test@example.com", "StrongP@ss1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("usr", "test@example.com", "StrongP@ss1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "invalid-email", "StrongP@ss1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "test@example.com", "weakpass"));
    }
}
