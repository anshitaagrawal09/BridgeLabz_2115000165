import java.util.*;
// Abstract Class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println(holderName + " deposited $" + amount + " | New Balance: $" + balance);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println(holderName + " has insufficient funds!");
        }
    }
    public abstract double calculateInterest();
    public void displayAccountDetails() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holderName + " | Balance: $" + balance);
        System.out.println("Interest Earned: $" + calculateInterest());
        if (this instanceof Loanable) {
            System.out.println(((Loanable) this).calculateLoanEligibility());
        }
        System.out.println("--------------------------------");
    }
}
// Interface for Loanable Accounts
interface Loanable {
    void applyForLoan(double amount);
    String calculateLoanEligibility();
}
// Savings Account (Loanable)
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return balance * 0.04; // 4% annual interest
    }

    public void applyForLoan(double amount) {
        System.out.println(holderName + " applied for a loan of $" + amount);
    }

    public String calculateLoanEligibility() {
        return "Loan Eligibility: $" + (balance * 5);
    }
}
// Current Account (Non-Loanable)
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return balance * 0.02; // 2% annual interest
    }
}
// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts =new ArrayList<>();
        accounts.add(new SavingsAccount("S123", "Alice", 5000));
        accounts.add(new CurrentAccount("C456", "Bob", 3000));
        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
            acc.deposit(1000);
            acc.withdraw(2000);
            System.out.println();
        }
    }
}
