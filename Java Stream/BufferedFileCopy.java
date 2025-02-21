import java.io.*;
public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB buffer size
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";  // Large file (100MB+)
        String destBuffered = "copy_buffered.dat";   // Destination file (Buffered)
        String destUnbuffered = "copy_unbuffered.dat"; // Destination file (Unbuffered)
        // Measure execution time for Unbuffered Streams
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        // Measure execution time for Buffered Streams
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        // Print execution times
        System.out.println("\nPerformance Comparison:");
        System.out.println("Unbuffered Streams Time: " + unbufferedTime + " ns");
        System.out.println("Buffered Streams Time: " + bufferedTime + " ns");
        System.out.println("Buffered Copy is " + (unbufferedTime / (double) bufferedTime) + "x faster!");
    }

    //Method 1: Copy using Unbuffered Streams
    private static long copyUsingUnbufferedStreams(String src, String dest) {
        long startTime = System.nanoTime(); // Start time
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int byteData;
            while ((byteData = fis.read()) != -1) { // Read one byte at a time
                fos.write(byteData);
            }
            System.out.println("Unbuffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error in Unbuffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime; // End time
    }

    //Method 2: Copy using Buffered Streams
    private static long copyUsingBufferedStreams(String src, String dest) {
        long startTime = System.nanoTime(); // Start time
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[BUFFER_SIZE]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error in Buffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime; // End time
    }
}
