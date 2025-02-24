import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) { // Private method
        return a * b;
    }
}

public class ReflectionPrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator(); // Creating an object

            // Accessing private method 'multiply' using Reflection
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true); // Allow access to private method

            // Invoking the private method with parameters (5, 3)
            int result = (int) method.invoke(calculator, 5, 3);

            // Display the result
            System.out.println("Result of multiply(5, 3): " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
