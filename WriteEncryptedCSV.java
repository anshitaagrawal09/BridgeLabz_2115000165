import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEncryptedCSV {
    public static void main(String[] args) {
        String csvFile = "employees_encrypted.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header
            String[] header = {"ID", "Name", "Department", "Salary", "Email"};
            writer.writeNext(header);

            // Employee records (Before encryption)
            String[][] employees = {
                    {"101", "John Doe", "IT", "60000", "john.doe@example.com"},
                    {"102", "Jane Smith", "HR", "55000", "jane.smith@example.com"},
                    {"103", "Alice Brown", "Finance", "70000", "alice.brown@example.com"}
            };

            // Encrypt and write records
            for (String[] emp : employees) {
                String encryptedSalary = AESUtil.encrypt(emp[3]); // Encrypt Salary
                String encryptedEmail = AESUtil.encrypt(emp[4]);  // Encrypt Email

                writer.writeNext(new String[]{emp[0], emp[1], emp[2], encryptedSalary, encryptedEmail});
            }

            System.out.println("Encrypted CSV file written successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
