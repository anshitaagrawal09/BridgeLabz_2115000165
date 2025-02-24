import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value(); // The required role to access the method
}

// Step 2: Create a User class with roles
class User {
    private String username;
    private String role; // Role of the user (e.g., "ADMIN", "USER")

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Create a SecureService class with role-restricted methods
class SecureService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    public void performGeneralTask() {
        System.out.println("General task executed.");
    }
}

// Step 4: Implement Role-Based Access Control (RBAC) using Reflection
public class RoleAccessControl {
    public static void invokeMethodIfAllowed(User user, Object object, String methodName) {
        try {
            Method method = object.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                if (!annotation.value().equals(user.getRole())) {
                    System.out.println("Access Denied! User does not have required role: " + annotation.value());
                    return;
                }
            }
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureService service = new SecureService();
        
        User adminUser = new User("Alice", "ADMIN");
        User normalUser = new User("Bob", "USER");

        System.out.println("Attempt by ADMIN:");
        invokeMethodIfAllowed(adminUser, service, "performAdminTask"); // Allowed

        System.out.println("\nAttempt by USER:");
        invokeMethodIfAllowed(normalUser, service, "performAdminTask"); // Access Denied

        System.out.println("\nGeneral method (no restriction):");
        invokeMethodIfAllowed(normalUser, service, "performGeneralTask"); // Allowed
    }
}
