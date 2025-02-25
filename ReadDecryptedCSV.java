import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDecryptedCSV {
    public static void main(String[] args) {
        String csvFile = "employees_encrypted.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                String decryptedSalary = AESUtil.decrypt(nextLine[3]); // Decrypt Salary
                String decryptedEmail = AESUtil.decrypt(nextLine[4]);  // Decrypt Email

                System.out.println("ID: " + nextLine[0] +
                        ", Name: " + nextLine[1] +
                        ", Department: " + nextLine[2] +
                        ", Salary: " + decryptedSalary +
                        ", Email: " + decryptedEmail);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
