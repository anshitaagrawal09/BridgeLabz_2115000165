import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToCsvConverter {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFile));
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

            // Write header
            String[] headers = {"ID", "Name", "Age", "Marks"};
            writer.writeNext(headers);

            // Write student data
            for (JsonNode node : rootNode) {
                String[] row = {
                        node.get("ID").asText(),
                        node.get("Name").asText(),
                        node.get("Age").asText(),
                        node.get("Marks").asText()
                };
                writer.writeNext(row);
            }
            writer.close();
            System.out.println("JSON successfully converted to CSV!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
