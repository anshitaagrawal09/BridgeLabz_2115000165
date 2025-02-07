// Base class BankAccount
class BankAccount {
    String accountNumber;
    double balance;
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}
// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate; // Interest rate in percentage
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
// Subclass CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit; // Maximum withdrawal limit per transaction
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
// Subclass FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int lockInPeriod; // Lock-in period in months
    FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}
// Main class to test the system
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("CA456", 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 10000, 12);
        savings.displayAccountInfo();
        savings.displayAccountType();
        System.out.println();
        checking.displayAccountInfo();
        checking.displayAccountType();
        System.out.println();
        fixedDeposit.displayAccountInfo();
        fixedDeposit.displayAccountType();
    }
}
