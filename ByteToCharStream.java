import java.io.*;
public class ByteToCharStream{
    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to your file path
        try {
            // Step 1: Read file as a byte stream
            FileInputStream fileInputStream = new FileInputStream(filePath);
            // Step 2: Convert byte stream to character stream (UTF-8 encoding)
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            // Step 3: Wrap InputStreamReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
            // Close the streams
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
