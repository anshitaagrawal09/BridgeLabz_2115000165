import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        try (CSVReader reader1 = new CSVReader(new FileReader(file1));
             CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            Map<String, String[]> studentMap = new HashMap<>();

            // Read first file (ID, Name, Age)
            reader1.readNext(); // Skip header
            String[] nextLine;
            while ((nextLine = reader1.readNext()) != null) {
                studentMap.put(nextLine[0], nextLine);
            }

            // Read second file (ID, Marks, Grade) and merge
            reader2.readNext(); // Skip header
            while ((nextLine = reader2.readNext()) != null) {
                if (studentMap.containsKey(nextLine[0])) {
                    String[] student = studentMap.get(nextLine[0]);
                    String[] mergedData = {student[0], student[1], student[2], nextLine[1], nextLine[2]};
                    writer.writeNext(mergedData);
                }
            }
            System.out.println("CSV files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
