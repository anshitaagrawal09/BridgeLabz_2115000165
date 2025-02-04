
class BankAccount{
    private static String bankName="Global Bank";
    private static int totalAccounts=0;
    private String accountHolderName;
    private final int accountNumber;

    //Constructor
    public BankAccount(String accountHolderName,int accountNumber){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        totalAccounts++;
    }

    public static void getTotalAccounts(){
        System.out.println("Total Accounts=>"+totalAccounts);
    }

    //Display account details
    public void displayAccountDetails(){
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1001);
        BankAccount acc2 = new BankAccount("Bob", 1002);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        // Display total accounts
        BankAccount.getTotalAccounts();
    }
}

