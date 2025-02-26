import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(new File("people.json"));

        List<JsonNode> filteredPeople = new ArrayList<>();
        
        for (JsonNode person : rootNode) {
            if (person.get("age").asInt() > 25) {
                filteredPeople.add(person);
            }
        }

        System.out.println(objectMapper.writeValueAsString(filteredPeople));
    }
}
