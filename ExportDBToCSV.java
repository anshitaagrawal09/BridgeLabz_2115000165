import java.sql.*;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportDBToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/employees_db";
        String username = "root";
        String password = "password";
        String csvFile = "employee_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            writer.writeAll(rs, true);
            System.out.println("CSV report generated successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
