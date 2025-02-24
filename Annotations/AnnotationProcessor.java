import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a custom annotation @ImportantMethod
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with a default value
}

// Step 2: Apply @ImportantMethod to methods in a class
class Service {

    @ImportantMethod(level = "HIGH")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void validateData() {
        System.out.println("Validating data...");
    }

    public void helperMethod() {
        System.out.println("This is just a helper method.");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<Service> obj = Service.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}
