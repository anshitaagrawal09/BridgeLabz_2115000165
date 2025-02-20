import java.util.*;
import java.time.*;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public String toString() {
        return "[Policy No: " + policyNumber + ", Holder: " + policyholderName +
               ", Expiry: " + expiryDate + ", Type: " + coverageType +
               ", Premium: $" + premiumAmount + "]";
    }
}
public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private LinkedHashMap<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>();
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    public List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicyMap.entrySet()) {
            if (!entry.getKey().isAfter(cutoffDate)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedPolicyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().policyNumber);
                orderedPolicyMap.remove(entry.getValue().policyNumber);
                iterator.remove();
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        // Sample Policies
        manager.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.of(2025, 3, 10), "Health", 1200.50));
        manager.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.of(2024, 3, 5), "Auto", 800.75));
        manager.addPolicy(new InsurancePolicy("P103", "Alice", LocalDate.of(2024, 4, 1), "Home", 1500.00));
        // Retrieve a policy
        System.out.println("Policy P102: " + manager.getPolicyByNumber("P102"));
        // Policies expiring in next 30 days
        System.out.println("\nPolicies Expiring Soon: " + manager.getExpiringPolicies());
        // Policies for a specific policyholder
        System.out.println("\nAlice's Policies: " + manager.getPoliciesByHolder("Alice"));
        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies: " + manager.policyMap.values());
    }
}
