import java.io.*;
import java.util.Arrays;
public class StringVsStreamComparison {
    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        compareStringBuilderAndStringBuffer();
        // Compare FileReader and InputStreamReader
        compareFileReaderAndInputStreamReader("large_file.txt"); // Change this to your file path
    }
    public static void compareStringBuilderAndStringBuffer() {
        int iterations = 1_000_000;
        String text = "hello";
        // Measure StringBuilder performance
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");
        // Measure StringBuffer performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    public static void compareFileReaderAndInputStreamReader(String filePath) {
        long startTime, endTime;
        int wordCount = 0;
        // Read file using FileReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            startTime = System.nanoTime();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        // Reset word count for InputStreamReader
        wordCount = 0;
        // Read file using InputStreamReader
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            startTime = System.nanoTime();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}
