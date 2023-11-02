import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: $" + balance;
    }
}

public class BankingApplicationOfferedByPwSkills {
    private static Map<String, Account> accounts = new HashMap<>();
    private static int accountCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Console Banking Application");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    depositFunds(scanner);
                    break;
                case 3:
                    withdrawFunds(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using our Banking Application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter the account holder's name: ");
        String accountHolder = scanner.nextLine();
        String accountNumber = "ACC" + accountCounter;
        accountCounter++;

        accounts.put(accountNumber, new Account(accountNumber, accountHolder, 0.0));
        System.out.println("Account created successfully. Your account number is: " + accountNumber);
    }

    private static void depositFunds(Scanner scanner) {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter the amount to deposit: $");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).deposit(amount);
            System.out.println("Deposit successful. New balance: $" + accounts.get(accountNumber).getBalance());
        } else {
            System.out.println("Account not found. Please check your account number.");
        }
    }

    private static void withdrawFunds(Scanner scanner) {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter the amount to withdraw: $");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).withdraw(amount);
            System.out.println("Withdrawal successful. New balance: $" + accounts.get(accountNumber).getBalance());
        } else {
            System.out.println("Account not found. Please check your account number.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println(accounts.get(accountNumber));
        } else {
            System.out.println("Account not found. Please check your account number.");
        }
    }
}
