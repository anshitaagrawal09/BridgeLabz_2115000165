import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Use @TaskInfo annotation in TaskManager class
class TaskManager {
    
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Completing an important task...");
    }
}

// Step 3: Retrieve annotation details using Reflection API
public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
