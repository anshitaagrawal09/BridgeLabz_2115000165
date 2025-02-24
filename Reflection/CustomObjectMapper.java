import java.lang.reflect.Field;
import java.util.Map;

// Sample class to be populated
class User {
    private String name;
    private int age;

    public void display() {
        System.out.println("User{name='" + name + "', age=" + age + "}");
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate through map and set values to fields
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true); // Allow modifying private fields
                    field.set(obj, entry.getValue()); // Set the field value
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + entry.getKey() + "' does not exist in " + clazz.getSimpleName());
                }
            }

            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        // Sample map with field values
        Map<String, Object> userData = Map.of(
            "name", "Alice",
            "age", 25
        );

        // Convert map to User object
        User user = toObject(User.class, userData);

        // Display the populated object
        user.display();
    }
}
