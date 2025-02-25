import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVOpenCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean firstLine = true;

            while ((nextLine = reader.readNext()) != null) {
                // Skip header row
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Print structured output
                System.out.println("Student ID: " + nextLine[0]);
                System.out.println("Name: " + nextLine[1]);
                System.out.println("Age: " + nextLine[2]);
                System.out.println("Marks: " + nextLine[3]);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
