package com.nianci.javabank.app;

import com.nianci.javabank.model.Account;
import com.nianci.javabank.service.BankService;

import java.util.Scanner;

public class JavaBankApp {

    private static final BankService bankService = new BankService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                System.out.println("\n1. Create Account");
                System.out.println("2. View Account");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Transfer");
                System.out.println("6. Transaction History");
                System.out.println("7. Month End Process");
                System.out.println("8. Exit");
                System.out.print("Choose option: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch(choice) {
                    case 1: createAccount(); break;
                    case 2: viewAccount(); break;
                    case 3: deposit(); break;
                    case 4: withdraw(); break;
                    case 5: transfer(); break;
                    case 6: history(); break;
                    case 7: monthEnd(); break;
                    case 8:
                        System.out.println("Exiting program.");
                        System.exit(0);
                        break;
                    default: System.out.println("Invalid option. Please enter a number between 1-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void createAccount() {
        System.out.print("Owner name: "); String owner = scanner.nextLine();
        System.out.print("Type (savings/checking): "); String type = scanner.nextLine();
        try {
            Account acc = bankService.createAccount(owner, type);
            System.out.println("Created account with ID: " + acc.getId());
        } catch (Exception e) { System.out.println(e.getMessage());}
    }

    private static void viewAccount() {
        System.out.print("Account ID: "); String id = scanner.nextLine();
        Account acc = bankService.getAccount(id);
        if(acc != null) System.out.println("Owner: " + acc.getOwner() + ", Balance: $" + acc.getBalance());
        else System.out.println("Account not found");
    }

    private static void deposit() {
        System.out.print("Account ID: "); String id = scanner.nextLine();
        System.out.print("Amount: "); double amount = scanner.nextDouble(); scanner.nextLine();
        try {
            bankService.getAccount(id).deposit(amount);
            System.out.println("Deposited $" + amount);
        } catch(Exception e) { System.out.println(e.getMessage()); }
    }

    private static void withdraw() {
        System.out.print("Account ID: "); String id = scanner.nextLine();
        System.out.print("Amount: "); double amount = scanner.nextDouble(); scanner.nextLine();
        try {
            bankService.getAccount(id).withdraw(amount);
            System.out.println("Withdrew $" + amount);
        } catch(Exception e) { System.out.println(e.getMessage()); }
    }

    private static void transfer() {
        System.out.print("From Account ID: "); String fromId = scanner.nextLine();
        System.out.print("To Account ID: "); String toId = scanner.nextLine();
        System.out.print("Amount: "); double amount = scanner.nextDouble(); scanner.nextLine();
        try {
            bankService.getAccount(fromId).transferTo(bankService.getAccount(toId), amount);
            System.out.println("Transferred $" + amount);
        } catch(Exception e) { System.out.println(e.getMessage()); }
    }

    private static void history() {
        System.out.print("Account ID: "); String id = scanner.nextLine();
        Account acc = bankService.getAccount(id);
        if(acc != null) acc.getTransactions().forEach(System.out::println);
        else System.out.println("Account not found");
    }

    private static void monthEnd() {
        bankService.monthEndProcess();
        System.out.println("Month end processing completed");
    }
}
