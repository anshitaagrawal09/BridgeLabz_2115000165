import java.lang.reflect.Method;

// Step 1: Create a sample class with methods to time
class MathOperations {
    public void fastMethod() {
        // Simulate fast execution
        System.out.println("Fast method executed.");
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulate slow execution (1 sec)
            System.out.println("Slow method executed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 2: Reflection-based method execution timer
public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            long startTime = System.nanoTime(); // Start timer
            method.invoke(obj); // Invoke the method dynamically
            long endTime = System.nanoTime(); // End timer

            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("Execution time of " + methodName + ": " + duration + " ms");
        } catch (Exception e) {
            System.out.println("Error executing method: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();

        // Measure execution time of methods
        measureExecutionTime(mathOps, "fastMethod");
        measureExecutionTime(mathOps, "slowMethod");
    }
}
