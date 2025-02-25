import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header

            // Sort by Salary (Descending)
            records.sort((a, b) -> Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3])));

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(records.get(i)[1] + " - $" + records.get(i)[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
