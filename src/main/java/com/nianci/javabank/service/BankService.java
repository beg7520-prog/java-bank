package com.nianci.javabank.service;

import com.nianci.javabank.model.Account;
import com.nianci.javabank.model.CheckingAccount;
import com.nianci.javabank.model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String owner, String type) {
        Account acc;
        if(type.equalsIgnoreCase("savings")) {
            acc = new SavingsAccount(owner);
        } else if(type.equalsIgnoreCase("checking")) {
            acc = new CheckingAccount(owner);
        } else {
            throw new IllegalArgumentException("Unknown account type");
        }
        accounts.put(acc.getId(), acc);
        return acc;
    }

    public Account getAccount(String id) {
        return accounts.get(id);
    }

    public void monthEndProcess() {
        for(Account acc : accounts.values()) {
            acc.monthEndProcess();
        }
    }

    public Map<String, Account> getAllAccounts() {
        return accounts;
    }
}
