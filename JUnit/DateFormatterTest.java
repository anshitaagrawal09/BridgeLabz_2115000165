import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2022", DateFormatter.formatDate("2022-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("12/25/2023"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2023.12.25"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("invalid-date"));
    }
}
