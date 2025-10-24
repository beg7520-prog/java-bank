package com.nianci.javabank.app;

import com.nianci.javabank.model.Account;
import com.nianci.javabank.service.BankService;

public class BankAppTestSimulation {

    public static void main(String[] args) {
        BankService bankService = new BankService();

        System.out.println("=== Mini Bank CLI Simulation Test ===");

        // 1️⃣ Create Accounts
        Account acc1 = bankService.createAccount("Alice", "savings");
        Account acc2 = bankService.createAccount("Bob", "checking");
        System.out.println("Created accounts:");
        System.out.println(acc1.getId() + " - " + acc1.getOwner());
        System.out.println(acc2.getId() + " - " + acc2.getOwner());

        // 2️⃣ Deposit
        acc1.deposit(1000);
        acc2.deposit(500);
        System.out.println("Deposits done.");

        // 3️⃣ Withdraw
        acc1.withdraw(200);
        acc2.withdraw(50);
        System.out.println("Withdrawals done.");

        // 4️⃣ Transfer
        acc1.transferTo(acc2, 300);
        System.out.println("Transfer done.");

        // 5️⃣ Month End Process
        bankService.monthEndProcess();
        System.out.println("Month-end process done.");

        // 6️⃣ Print Transaction History
        System.out.println("\n=== Transaction History for " + acc1.getOwner() + " ===");
        acc1.getTransactions().forEach(System.out::println);

        System.out.println("\n=== Transaction History for " + acc2.getOwner() + " ===");
        acc2.getTransactions().forEach(System.out::println);

        // 7️⃣ Print final balances
        System.out.println("\n=== Final Balances ===");
        System.out.println(acc1.getOwner() + ": $" + acc1.getBalance());
        System.out.println(acc2.getOwner() + ": $" + acc2.getBalance());
    }
}
