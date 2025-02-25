import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"101", "Alice Johnson", "HR", "50000"};
            String[] emp2 = {"102", "Bob Smith", "IT", "60000"};
            String[] emp3 = {"103", "Charlie Brown", "Finance", "55000"};
            String[] emp4 = {"104", "David White", "IT", "65000"};
            String[] emp5 = {"105", "Eve Adams", "Marketing", "52000"};

            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.writeNext(emp3);
            writer.writeNext(emp4);
            writer.writeNext(emp5);

            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
