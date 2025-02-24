import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Step 2: Apply @LogExecutionTime annotation to methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(500); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Use Reflection to measure execution time
public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime(); // Start time
                method.invoke(test); // Invoke the method
                long endTime = System.nanoTime(); // End time
                
                long executionTime = endTime - startTime; // Calculate execution time
                System.out.println("Method: " + method.getName() + " executed in " + executionTime + " nanoseconds");
                System.out.println("----------------------");
            }
        }
    }
}
