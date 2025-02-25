import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_file.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            int batchSize = 100;

            while ((line = br.readLine()) != null) {
                count++;
                if (count % batchSize == 0) {
                    System.out.println("Processed " + count + " records...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
