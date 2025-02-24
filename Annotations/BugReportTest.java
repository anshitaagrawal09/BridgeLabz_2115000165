import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the @BugReport annotation and make it repeatable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Use @BugReport annotation multiple times on a method
class SoftwareModule {

    @BugReport(description = "NullPointerException occurs on empty input")
    @BugReport(description = "IndexOutOfBoundsException when input size is too large")
    public void process() {
        System.out.println("Processing data...");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection API
public class BugReportTest {
    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("process");

        // Check for multiple @BugReport annotations
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }
    }
}
