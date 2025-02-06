
import java.util.ArrayList;
import java.util.List;
class Bank {
    String name;
    List<Account> accounts;
    Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    void openAccount(Customer customer, double balance) {
        Account account = new Account(this, customer, balance);
        accounts.add(account);
        customer.addAccount(account);
    }
    void showAccounts() {
        System.out.println("Bank: " + name);
        for (Account acc : accounts) {
            System.out.println("Account Holder: " + acc.customer.name + ", Balance: $" + acc.balance);
        }
    }
}
class Account {
    Bank bank;
    Customer customer;
    double balance;
    Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }
}
class Customer {
    String name;
    List<Account> accounts;
    Customer(String name){
        this.name=name;
        this.accounts=new ArrayList<>();
    }
    void addAccount(Account account) {
        accounts.add(account);
    }
    void viewBalance(){
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.bank.name + ", Balance: $" + acc.balance);
        }
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("ABC Bank");
        Bank bank2 = new Bank("XYZ Bank");
        Customer cust1 = new Customer("Alice");
        Customer cust2 = new Customer("Bob");
        bank1.openAccount(cust1, 5000);
        bank1.openAccount(cust2, 3000);
        bank2.openAccount(cust1, 7000);
        bank1.showAccounts();
        bank2.showAccounts();
        cust1.viewBalance();
        cust2.viewBalance();
    }
}

