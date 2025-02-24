import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a custom annotation @Todo
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();           // Description of the task
    String assignedTo();     // Developer responsible
    String priority() default "MEDIUM"; // Default priority is "MEDIUM"
}

// Step 2: Apply @Todo annotation to multiple methods
class Project {

    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeQueries() {
        System.out.println("Optimizing queries...");
    }

    @Todo(task = "Implement payment gateway", assignedTo = "Charlie", priority = "CRITICAL")
    public void setupPayment() {
        System.out.println("Setting up payment gateway...");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection API
public class TodoTracker {
    public static void main(String[] args) {
        Class<Project> obj = Project.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
                System.out.println("----------------------");
            }
        }
    }
}
