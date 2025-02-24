import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name(); // Custom JSON key name
}

// Step 2: Create User class with @JsonField
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String hiddenField; // This field won't be serialized

    public User(String username, int age, String hiddenField) {
        this.username = username;
        this.age = age;
        this.hiddenField = hiddenField;
    }
}

// Step 3: JSON Serializer using Reflection
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Map<String, String> jsonMap = new HashMap<>();
            Class<?> clazz = obj.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true); // Allow access to private fields
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            return jsonMapToJsonString(jsonMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error during serialization", e);
        }
    }

    private static String jsonMapToJsonString(Map<String, String> jsonMap) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (json.length() > 1) {
            json.delete(json.length() - 2, json.length()); // Remove trailing comma
        }
        json.append("}");
        return json.toString();
    }
}

// Step 4: Main class to test serialization
public class JsonFieldTest {
    public static void main(String[] args) {
        User user = new User("Alice", 25, "SecretData");
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
