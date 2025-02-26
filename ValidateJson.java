import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String validJson = "{\"name\":\"Alice\",\"age\":25}";
        String invalidJson = "{name:\"Alice\",age:25}"; // Invalid JSON

        System.out.println("Valid JSON: " + isValidJson(validJson));
        System.out.println("Invalid JSON: " + isValidJson(invalidJson));
    }

    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
