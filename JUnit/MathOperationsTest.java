import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathOperationsTest {
    private final MathOperations mathOperations = new MathOperations();

    @Test
    void testDivide() {
        assertEquals(2, mathOperations.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> mathOperations.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
