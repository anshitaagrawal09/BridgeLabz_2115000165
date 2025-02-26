import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        String json = objectMapper.writeValueAsString(objectMapper.readTree(new File("data.json")));
        String xml = xmlMapper.writeValueAsString(objectMapper.readTree(json));

        System.out.println(xml);
    }
}
