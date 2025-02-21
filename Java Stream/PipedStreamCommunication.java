import java.io.*;
class WriterThread extends Thread {
    private PipedOutputStream pos;
    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }
    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); // Writing data as bytes
            System.out.println("Writer: Data written to pipe.");
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        } finally {
            try {
                pos.close(); // Close the stream after writing
            } catch (IOException e) {
                System.out.println("Error closing PipedOutputStream: " + e.getMessage());
            }
        }
    }
}
class ReaderThread extends Thread {
    private PipedInputStream pis;
    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }
    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer); // Read data from the pipe
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader: Received -> " + receivedMessage);
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        } finally {
            try {
                pis.close(); // Close the stream after reading
            } catch (IOException e) {
                System.out.println("Error closing PipedInputStream: " + e.getMessage());
            }
        }
    }
}
public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect pipes
            // Create and start threads
            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);
            writer.start();
            reader.start();
            // Wait for threads to finish
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Main Thread Error: " + e.getMessage());
        }
    }
}
