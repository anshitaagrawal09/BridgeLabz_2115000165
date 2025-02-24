import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Step 1: Define @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Step 2: Create a simple Service interface and implementation
interface Service {
    void serve();
}

class ServiceImpl implements Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

// Step 3: Create a class that depends on Service
class Client {
    @Inject // This field should be injected dynamically
    private Service service;

    public void doWork() {
        service.serve();
    }
}

// Step 4: Create a simple DI container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        // Create an instance and store it
        Object instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);
    }

    public void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);
                if (dependency == null) {
                    // If dependency not found, create and register it
                    dependency = fieldType.getDeclaredConstructor().newInstance();
                    instances.put(fieldType, dependency);
                }
                field.setAccessible(true); // Allow setting private fields
                field.set(object, dependency); // Inject the dependency
            }
        }
    }
}

// Step 5: Test the DI system
public class SimpleDIContainer {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();

        // Register the ServiceImpl class
        container.register(ServiceImpl.class);

        // Create a Client instance and inject dependencies
        Client client = new Client();
        container.injectDependencies(client);

        // Use the injected service
        client.doWork(); // Should print: "Service is running..."
    }
}
