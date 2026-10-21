
import java.util.Scanner;

abstract class Account {
    private int accountNumber;
    private double balance;
    private static int nextAccountNumber = 1001;

    public Account(double balance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            return false;
        }

        double fee = calculateWithdrawalFee();

        if (balance < amount + fee) {
            return false;
        }

        balance -= amount + fee;
        return true;
    }

    public abstract double calculateWithdrawalFee();

    public abstract String getAccountType();
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 0.0;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 10.0;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}

public class OOPMIDTERMLabAcitivy5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the OOP Banking System");

        double openingBalance = readNonNegativeBalance();

        SavingsAccount savingsAccount = new SavingsAccount(openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount(openingBalance);

        Account selectedAccount = savingsAccount;

        printAccountSummary(selectedAccount);

        while (true) {
            showMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount to withdraw: ");
                    double withdrawal = readPositiveAmount();

                    if (withdrawal <= 0) {
                        System.out.println("Invalid amount. Please enter a positive number.");
                        break;
                    }

                    double fee = selectedAccount.calculateWithdrawalFee();

                    if (selectedAccount.withdraw(withdrawal)) {
                        System.out.printf("Withdrawal fee: ₱%.2f%n", fee);
                        printAccountSummary(selectedAccount);
                    } else {
                        System.out.println("Insufficient balance.");
                        printAccountSummary(selectedAccount);
                    }
                    break;

                case 2:
                    System.out.print("Amount to deposit: ");
                    double deposit = readPositiveAmount();

                    if (deposit <= 0) {
                        System.out.println("Invalid amount. Please enter a positive number.");
                        break;
                    }

                    selectedAccount.deposit(deposit);
                    printAccountSummary(selectedAccount);
                    break;

                case 3:
                    printAccountSummary(selectedAccount);
                    break;

                case 4:
                    if (selectedAccount == savingsAccount) {
                        selectedAccount = checkingAccount;
                    } else {
                        selectedAccount = savingsAccount;
                    }

                    printAccountSummary(selectedAccount);
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose from 1 to 5.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n1 Withdraw   2 Deposit   3 Show balance");
        System.out.println("4 Switch account   5 Exit");
        System.out.print("Choice: ");
    }

    public static double readNonNegativeBalance() {
        while (true) {
            System.out.print("Opening balance: ");

            if (scanner.hasNextDouble()) {
                double balance = scanner.nextDouble();

                if (Double.isFinite(balance) && balance >= 0) {
                    return balance;
                }

                System.out.println("Invalid! Balance must be zero or greater.");
            } else {
                System.out.println("Invalid! Please enter a number.");
                scanner.next();
            }
        }
    }

    public static double readPositiveAmount() {
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();

            if (Double.isFinite(amount) && amount > 0) {
                return amount;
            }
        } else {
            scanner.next();
        }

        return -1;
    }

    public static void printAccountSummary(Account account) {
        System.out.printf(
            "Current account: %s | Account Number: %d | Balance: ₱%.2f%n",
            account.getAccountType(),
            account.getAccountNumber(),
            account.getBalance()
        );
    }
}
