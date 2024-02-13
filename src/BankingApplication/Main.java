package BankingApplication;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("Welcome to the Banking Application!");
            System.out.println("Please select an option:");
            System.out.println("1. Create a new account\n2. Deposit money\n3. Withdraw money\n4. Check balance\n5. Exit");
            scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your initial deposit:");
                    double initialDeposit = scanner.nextDouble();
                    Account account = new Account(AccountDAO.getNextCustomerId(), "Savings", initialDeposit, name);
                    AccountDAO.addAccount(account);
                    System.out.println("Account created successfully!");
                    System.out.println("Your account number is " + AccountDAO.getNextCustomerId());
                    break;
                case 2:
                    System.out.println("Enter your account number:");
                    int accountNumber = scanner.nextInt();
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    AccountDAO.depositToAccount(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter your account number:");
                    accountNumber = scanner.nextInt();
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    AccountDAO.withdrawFromAccount(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter your account number:");
                    accountNumber = scanner.nextInt();
                    AccountDAO.checkBalance(accountNumber);
                    break;
                case 5:
                    System.out.println("Thank you for using the Banking Application!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
