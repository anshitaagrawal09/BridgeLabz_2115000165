import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            MathOperations mathOps = new MathOperations();

            // Ask user for method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Get the method dynamically
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Get user inputs for numbers
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Invoke the selected method dynamically
            int result = (int) method.invoke(mathOps, num1, num2);

            // Print the result
            System.out.println("Result: " + result);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
