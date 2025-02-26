import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateStudentJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> student = new HashMap<>();
        student.put("name", "John Doe");
        student.put("age", 20);
        student.put("subjects", Arrays.asList("Math", "Science", "History"));

        String json = objectMapper.writeValueAsString(student);
        System.out.println(json);
    }
}
