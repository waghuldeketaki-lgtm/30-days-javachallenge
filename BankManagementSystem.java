import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Bank Account
class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance $" + balance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited $" + amount);
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew $" + amount);
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Display transaction history
    public void showTransactions() {
        System.out.println("Transaction History for " + accountNumber + ":");
        for (String t : transactionHistory) {
            System.out.println("- " + t);
        }
    }

    // Getter for account number (for searching)
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Main class
public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- Bank Management Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Details");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    accounts.add(new BankAccount(name, accNum, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAcc = sc.nextLine();
                    BankAccount depositAccount = findAccount(accounts, depAcc);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depAmount = sc.nextDouble();
                        depositAccount.deposit(depAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String witAcc = sc.nextLine();
                    BankAccount withdrawAccount = findAccount(accounts, witAcc);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double witAmount = sc.nextDouble();
                        withdrawAccount.withdraw(witAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String detAcc = sc.nextLine();
                    BankAccount detailAccount = findAccount(accounts, detAcc);
                    if (detailAccount != null) {
                        detailAccount.displayDetails();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String tranAcc = sc.nextLine();
                    BankAccount transAccount = findAccount(accounts, tranAcc);
                    if (transAccount != null) {
                        transAccount.showTransactions();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    // Helper method to find account by number
    public static BankAccount findAccount(ArrayList<BankAccount> accounts, String accNum) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accNum)) {
                return account;
            }
        }
        return null;
    }
}