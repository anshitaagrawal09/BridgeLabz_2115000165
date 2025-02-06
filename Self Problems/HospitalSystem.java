
import java.util.ArrayList;
import java.util.List;
// Patient class (Associated with Doctors)
class Patient {
    private String name;
    private List<Doctor> consultedDoctors;
    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addConsultedDoctor(Doctor doctor) {
        consultedDoctors.add(doctor);
    }
    public void showConsultations() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor doctor : consultedDoctors) {
            System.out.println(" - Dr. " + doctor.getName());
        }
    }
}
// Doctor class (Associated with Patients)
class Doctor {
    private String name;
    private List<Patient> patients;
    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void consult(Patient patient) {
        patients.add(patient);
        patient.addConsultedDoctor(this); // Maintain bidirectional association
        System.out.println("Dr. " + name + " is consulting Patient: " + patient.getName());
    }
    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}
// Hospital class (Contains Doctors but does not own them)
class Hospital {
    private String name;
    private List<Doctor> doctors;
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void showDoctors() {
        System.out.println("Hospital: " + name + " has the following doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.getName());
        }
    }
}
// Main class
public class HospitalSystem {
    public static void main(String[] args) {
        // Create Hospital
        Hospital hospital = new Hospital("City Hospital");
        // Create Doctors
        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");
        // Add Doctors to Hospital
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        // Create Patients
        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");
        // Consultations (Many-to-Many Association)
        drSmith.consult(alice);
        drSmith.consult(bob);
        drJones.consult(alice); // Alice consults multiple doctors
        // Show Hospital Doctors
        hospital.showDoctors();
        // Show Consultations for Each Doctor
        drSmith.showPatients();
        drJones.showPatients();
        // Show Consultations for Each Patient
        alice.showConsultations();
        bob.showConsultations();
    }
}

