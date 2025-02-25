import com.opencsv.*;
import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records = reader.readAll();
            records.get(0)[3] = "Updated Salary"; // Modify header

            for (int i = 1; i < records.size(); i++) {
                if (records.get(i)[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(records.get(i)[3]);
                    salary *= 1.10; // Increase by 10%
                    records.get(i)[3] = String.valueOf((int) salary);
                }
            }

            writer.writeAll(records);
            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
