package com.nianci.javabank.model;

public class CheckingAccount extends Account {
    private double fee = 5.0;

    public CheckingAccount(String owner) {
        super(owner);
    }

    @Override
    public void monthEndProcess() {
        balance -= fee;
        record("Monthly maintenance fee deducted: $" + fee);
    }
}
