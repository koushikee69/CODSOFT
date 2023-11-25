import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds
        }
    }
}

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a account with an initial balance
        BankAccount userAccount = new BankAccount(5000.0);

        // Interface
        System.out.println("Welcome to the ATM!");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check Balance
                    displayBalance(userAccount);
                    break;
                case 2:
                    // Deposit
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    deposit(userAccount, depositAmount);
                    break;
                case 3:
                    // Withdraw
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(userAccount, withdrawalAmount);
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // display the account balance
    private static void displayBalance(BankAccount account) {
        System.out.println("Account Balance: $" + account.getBalance());
    }

    // deposit money into the account
    private static void deposit(BankAccount account, double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    // withdraw money from the account
    private static void withdraw(BankAccount account, double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}