import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                String email = nextLine[4];
                String phone = nextLine[5];

                if (!Pattern.matches(emailRegex, email)) {
                    System.out.println("Invalid Email: " + email);
                }
                if (!Pattern.matches(phoneRegex, phone)) {
                    System.out.println("Invalid Phone Number: " + phone);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
