import java.io.*;
public class FileCopyExample {
    public static void main(String[] args) {
        String sourceFile = "source.txt";   // Source file path
        String destinationFile = "destination.txt";  // Destination file path
        // File handling using FileInputStream & FileOutputStream
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            int byteData;
            while ((byteData = fis.read()) != -1) { // Read data byte by byte
                fos.write(byteData); // Write data to destination file
            }
            System.out.println("File copied successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file '" + sourceFile + "' not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
