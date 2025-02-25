import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                if (!seenIds.add(nextLine[0])) {
                    duplicateIds.add(nextLine[0]);
                }
            }

            if (!duplicateIds.isEmpty()) {
                System.out.println("Duplicate IDs: " + duplicateIds);
            } else {
                System.out.println("No duplicates found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
