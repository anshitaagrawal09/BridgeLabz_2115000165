import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public InsurancePolicy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) throws ParseException {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate);
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    // Override equals() and hashCode() for unique identification in Sets
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Comparable interface for sorting policies by expiry date
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy No: " + policyNumber + ", Name: " + policyholderName +
                ", Expiry: " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate) +
                ", Type: " + coverageType + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    public static void main(String[] args) throws ParseException {
        // Using different Sets
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        // Adding sample policies
        addPolicy(hashSet, linkedHashSet, treeSet, new InsurancePolicy("P1001", "Alice", "2024-03-10", "Health", 500.00));
        addPolicy(hashSet, linkedHashSet, treeSet, new InsurancePolicy("P1002", "Bob", "2024-02-25", "Auto", 300.00));
        addPolicy(hashSet, linkedHashSet, treeSet, new InsurancePolicy("P1003", "Charlie", "2024-04-15", "Home", 700.00));
        addPolicy(hashSet, linkedHashSet, treeSet, new InsurancePolicy("P1004", "Dave", "2024-02-20", "Auto", 400.00));

        System.out.println("\nAll Unique Policies (HashSet):");
        displayPolicies(hashSet);

        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");
        displayPolicies(linkedHashSet);

        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        displayPolicies(treeSet);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        displayPolicies(expiringSoon(treeSet));

        System.out.println("\nPolicies with Coverage Type 'Auto':");
        displayPolicies(filterByCoverageType(hashSet, "Auto"));

        System.out.println("\nFinding Duplicate Policies:");
        findDuplicatePolicies(hashSet);
    }

    // Method to add policy to all Sets
    private static void addPolicy(Set<InsurancePolicy> hashSet, Set<InsurancePolicy> linkedHashSet, Set<InsurancePolicy> treeSet, InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Display all policies in a given set
    private static void displayPolicies(Set<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring within 30 days
    private static Set<InsurancePolicy> expiringSoon(Set<InsurancePolicy> policies) {
        Set<InsurancePolicy> expiringPolicies = new HashSet<>();
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date thirtyDaysLater = cal.getTime();

        for (InsurancePolicy policy : policies) {
            if (policy.getExpiryDate().after(today) && policy.getExpiryDate().before(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Retrieve policies by coverage type
    private static Set<InsurancePolicy> filterByCoverageType(Set<InsurancePolicy> policies, String coverageType) {
        Set<InsurancePolicy> filteredPolicies = new HashSet<>();
        for (InsurancePolicy policy : policies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Find duplicate policies based on policy numbers
    private static void findDuplicatePolicies(Set<InsurancePolicy> policies) {
        Set<String> seenNumbers = new HashSet<>();
        boolean foundDuplicate = false;

        for (InsurancePolicy policy : policies) {
            if (!seenNumbers.add(policy.getPolicyNumber())) {
                System.out.println("Duplicate Policy Found: " + policy);
                foundDuplicate = true;
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicate policies found.");
        }
    }
}
