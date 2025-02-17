import java.io.*;
public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // give actual file location here
        System.out.println("Reading File: " + filePath);
        // FileReader (Character Stream)
        long startTime = System.nanoTime();
        readFileUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;
        // InputStreamReader (Byte Stream)
        startTime = System.nanoTime();
        readFileUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - startTime;
        System.out.println("FileReader Time: " + (fileReaderTime / 1_000_000.0) + " ms");
        System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1_000_000.0) + " ms");
    }
    public static void readFileUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFileUsingInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            while ((ch = inputStreamReader.read()) != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
