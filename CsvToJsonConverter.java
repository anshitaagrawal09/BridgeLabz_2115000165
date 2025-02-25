import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String jsonFile = "students_converted.json";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            String[] headers = reader.readNext(); // Read header row
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                arrayNode.add(objectMapper.createObjectNode()
                        .put(headers[0], nextLine[0])
                        .put(headers[1], nextLine[1])
                        .put(headers[2], nextLine[2])
                        .put(headers[3], nextLine[3]));
            }

            objectMapper.writeValue(new FileWriter(jsonFile), arrayNode);
            System.out.println("CSV successfully converted to JSON!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
