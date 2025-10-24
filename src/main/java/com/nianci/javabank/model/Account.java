package com.nianci.javabank.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    protected String id;
    protected String owner;
    protected double balance;
    protected List<String> transactions;

    public Account(String owner) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        record("Account created for " + owner);
    }

    public String getId() { return id; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
    public List<String> getTransactions() { return transactions; }

    protected void record(String message) { transactions.add(message); }

    public void deposit(double amount) {
        if(amount <= 0) throw new IllegalArgumentException("Invalid amount");
        balance += amount;
        record("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if(amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        record("Withdrew: $" + amount);
    }

    public void transferTo(Account target, double amount) {
        if(amount > balance) throw new IllegalArgumentException("Insufficient balance for transfer");
        this.withdraw(amount);
        target.deposit(amount);
        record("Transferred $" + amount + " to " + target.getOwner());
    }

    public abstract void monthEndProcess();
}
