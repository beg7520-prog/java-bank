package com.nianci.javabank.model;

public class SavingsAccount extends Account {
    private double interestRate = 0.01; // 1% monthly interest

    public SavingsAccount(String owner) {
        super(owner);
    }

    @Override
    public void monthEndProcess() {
        double interest = balance * interestRate;
        balance += interest;
        record("Monthly interest added: $" + interest);
    }
}
