import java.util.*;
class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();  // Stores account balances
    private TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>(); // Sort by balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // Queue for withdrawal requests
    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        // Maintain sorted balance list
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }
    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            // Update sortedAccounts
            sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
            if (sortedAccounts.get(oldBalance).isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }
    // Withdraw money (queue-based processing)
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Invalid account number.");
        }
    }
    // Process withdrawals
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                withdraw(accountNumber, amount);
                System.out.println("Processed withdrawal of $" + amount + " for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient funds for Account: " + accountNumber);
            }
        }
    }
    // Withdraw money (helper method)
    private void withdraw(int accountNumber, double amount) {
        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance - amount;
        accounts.put(accountNumber, newBalance);

        // Update sortedAccounts
        sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }
    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (Integer account : entry.getValue()) {
                System.out.println("Account: " + account + " - Balance: $" + entry.getKey());
            }
        }
    }
    // Display all accounts
    public void displayAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " - Balance: $" + entry.getValue());
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        // Adding accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);
        bank.addAccount(1004, 2000);
        bank.displayAccounts();
        bank.displaySortedAccounts();
        // Depositing money
        bank.deposit(1002, 1000);
        bank.displaySortedAccounts();
        // Withdrawal requests
        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1003);
        bank.processWithdrawals(2000);
        bank.displayAccounts();
        bank.displaySortedAccounts();
    }
}
