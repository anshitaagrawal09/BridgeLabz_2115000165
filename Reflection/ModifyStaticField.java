import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the class reference
            Class<?> clazz = Configuration.class;

            // Access the private static field "API_KEY"
            Field field = clazz.getDeclaredField("API_KEY");
            field.setAccessible(true); // Allow access to private field

            // Modify the static field
            field.set(null, "NEW_SECRET_KEY");

            // Print the updated value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
