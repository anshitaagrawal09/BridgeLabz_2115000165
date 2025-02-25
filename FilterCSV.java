import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                int marks = Integer.parseInt(nextLine[3]);
                if (marks > 80) {
                    System.out.println(nextLine[1] + " scored " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
