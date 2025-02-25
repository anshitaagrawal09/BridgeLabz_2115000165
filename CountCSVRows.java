import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int count = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip header
            while (reader.readNext() != null) {
                count++;
            }
            System.out.println("Total records: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
