package com.nianci.javabank.service;

import com.nianci.javabank.model.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    @Test
    public void testDepositAndWithdraw() {
        BankService bank = new BankService();
        Account acc = bank.createAccount("Alice", "savings");

        acc.deposit(500);
        assertEquals(500, acc.getBalance());

        acc.withdraw(200);
        assertEquals(300, acc.getBalance());
    }

    @Test
    public void testTransfer() {
        BankService bank = new BankService();
        Account acc1 = bank.createAccount("Alice", "savings");
        Account acc2 = bank.createAccount("Bob", "checking");

        acc1.deposit(400);
        acc1.transferTo(acc2, 150);

        assertEquals(250, acc1.getBalance());
        assertEquals(150, acc2.getBalance());
    }
}
