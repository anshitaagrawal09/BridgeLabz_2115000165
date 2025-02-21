import java.io.*;
public class StudentDataStream {
    private static final String FILE_NAME = "students.dat"; // Binary file
    public static void main(String[] args) {
        // Writing student data to binary file
        writeStudentData();
        // Reading and displaying student data from binary file
        readStudentData();
    }
    //Method 1: Write Student Data to Binary File
    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);
            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);
            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    // Method 2: Read Student Data from Binary File
    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nRetrieving Student Data:");
            while (dis.available() > 0) { // Check if data is available
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
