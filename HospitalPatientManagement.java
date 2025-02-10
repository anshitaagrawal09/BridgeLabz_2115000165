import java.util.ArrayList;
import java.util.List;
// Abstract Class: Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract Method: To be implemented by subclasses
    public abstract double calculateBill();

    // Concrete Method: Get patient details (Encapsulation applied)
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Concrete Class: InPatient (Stays in hospital, billed per day)
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.records = new ArrayList<>();
    }

    // Implement calculateBill()
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Implement MedicalRecord methods
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// Concrete Class: OutPatient (One-time consultation charge)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    // Implement calculateBill()
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Implement MedicalRecord methods
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// Hospital Management: Uses Polymorphism
class HospitalManagement {
    public static void processBilling(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: $" + patient.calculateBill());

        // Check if patient has medical records
        if (patient instanceof MedicalRecord) {
            MedicalRecord recordHolder = (MedicalRecord) patient;
            System.out.println("Medical Records: " + recordHolder.viewRecords());
        }

        System.out.println("---------------------------------");
    }
}

// Main Class: Demonstration
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Creating Patients
        InPatient inpatient = new InPatient("P1001", "John Doe", 45,  5, 2000);
        OutPatient outpatient = new OutPatient("P2001", "Jane Smith", 30, 500);

        // Adding Medical Records
        inpatient.addRecord("Admitted for Pneumonia treatment.");
        inpatient.addRecord("Prescribed antibiotics.");
        outpatient.addRecord("Consultation for Flu symptoms.");

        // Processing Billing (Polymorphism)
        HospitalManagement.processBilling(inpatient);
        HospitalManagement.processBilling(outpatient);
    }
}
