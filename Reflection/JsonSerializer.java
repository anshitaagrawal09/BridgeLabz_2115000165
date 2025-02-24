import java.lang.reflect.Field;

// Sample class to be converted to JSON
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            StringBuilder json = new StringBuilder("{");

            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Access private fields
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                json.append("\"").append(fieldName).append("\": ");

                // Handle String values with quotes
                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                // Add a comma if not the last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }

            json.append("}");
            return json.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error serializing object: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        // Create a sample object
        User user = new User("Alice", 25);

        // Convert object to JSON
        String jsonOutput = toJson(user);

        // Print the JSON string
        System.out.println(jsonOutput);
    }
}
