import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongPass1"), "Valid password failed");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Pass1"), "Short password passed");
    }

    @Test
    void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpass1"), "Password without uppercase passed");
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("NoDigitsHere"), "Password without digit passed");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Null password passed");
    }

    @Test
    void testOnlyDigitsAndUppercase() {
        assertFalse(PasswordValidator.isValid("12345678A"), "Only digit and uppercase passed");
    }
}
