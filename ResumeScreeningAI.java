import java.util.ArrayList;
import java.util.List;
// Step 1: Define the Abstract JobRole Class
abstract class JobRole {
    private String candidateName;
    private int experience; // In years
    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public int getExperience() {
        return experience;
    }
    public abstract String getRequiredSkills();
    public void displayJobDetails() {
        System.out.println("Candidate: " + candidateName + " | Experience: " + experience + " years");
        System.out.println("Required Skills: " + getRequiredSkills());
    }
}
// Step 2: Implement Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }
    @Override
    public String getRequiredSkills() {
        return "Java, Python, Data Structures, Algorithms";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }
    @Override
    public String getRequiredSkills() {
        return "Machine Learning, Python, SQL, Data Analysis";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }
    @Override
    public String getRequiredSkills() {
        return "Project Management, Business Strategy, Leadership";
    }
}
// Step 3: Generic Resume Class
class Resume<T extends JobRole> {
    private T jobRole;
    private String education;
    private double matchScore; // AI-based scoring
    public Resume(T jobRole, String education, double matchScore) {
        this.jobRole = jobRole;
        this.education = education;
        this.matchScore = matchScore;
    }
    public T getJobRole() {
        return jobRole;
    }
    public String getEducation() {
        return education;
    }
    public double getMatchScore() {
        return matchScore;
    }
    public void displayResume() {
        System.out.println("=== Resume Screening ===");
        jobRole.displayJobDetails();
        System.out.println("Education: " + education);
        System.out.println("Match Score: " + matchScore + "/100");
        System.out.println("------------------------");
    }
}
// Step 4: Resume Screening System with Wildcards
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumePool = new ArrayList<>();
    public <T extends JobRole> void submitResume(Resume<T> resume) {
        if (validateResume(resume)) {
            resumePool.add(resume);
            System.out.println(resume.getJobRole().getCandidateName() + "'s resume submitted successfully.");
        } else {
            System.out.println("Resume rejected due to low match score.");
        }
    }
    private boolean validateResume(Resume<? extends JobRole> resume) {
        return resume.getMatchScore() >= 50.0; // Simple threshold for AI-based screening
    }
    public void displayAllResumes() {
        System.out.println("\n=== AI-Driven Resume Screening ===");
        for (Resume<? extends JobRole> resume : resumePool) {
            resume.displayResume();
        }
    }
}
// Step 5: Main Class to Test the System
public class ResumeScreeningAI {
    public static void main(String[] args) {
        // Create job roles
        SoftwareEngineer seCandidate = new SoftwareEngineer("Alice", 3);
        DataScientist dsCandidate = new DataScientist("Bob", 5);
        ProductManager pmCandidate = new ProductManager("Charlie", 7);
        // Create resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(seCandidate, "BSc Computer Science", 85.0);
        Resume<DataScientist> dsResume = new Resume<>(dsCandidate, "MSc Data Science", 90.0);
        Resume<ProductManager> pmResume = new Resume<>(pmCandidate, "MBA Business Strategy", 75.0);
        Resume<SoftwareEngineer> rejectedResume = new Resume<>(new SoftwareEngineer("David", 1), "BSc IT", 40.0);
        // Create Resume Screening System
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();
        screeningSystem.submitResume(seResume);
        screeningSystem.submitResume(dsResume);
        screeningSystem.submitResume(pmResume);
        screeningSystem.submitResume(rejectedResume); // This should be rejected
        // Display all valid resumes
        screeningSystem.displayAllResumes();
    }
}
