import java.io.*;
import java.nio.file.Files;
public class ImageByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";    // Path to the original image
        String outputImagePath = "output.jpg";  // Path to save the new image
        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(inputImagePath);
            System.out.println("Image successfully converted to byte array!");
            // Convert byte array back to image
            byteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array successfully written back to image file!");
            // Verify if both files are identical
            if (Files.mismatch(new File(inputImagePath).toPath(), new File(outputImagePath).toPath()) == -1) {
                System.out.println("The new image is identical to the original image!");
            } else {
                System.out.println("The new image differs from the original image.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Method 1: Convert Image to Byte Array
    private static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    // Method 2: Convert Byte Array to Image
    private static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
