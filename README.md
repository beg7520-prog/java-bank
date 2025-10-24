# 🏦 Mini Banking System (Java OOP Project)

A simple **Java CLI application** demonstrating **OOP concepts** — encapsulation, inheritance, polymorphism, and exception handling.

## ✨ Features
- Create account (Savings / Checking)
- Deposit / Withdraw / Transfer
- Transaction history
- Monthly interest / fees processing

## 🧩 OOP Concepts
| Concept | Example |
|----------|----------|
| Encapsulation | Private fields + getters/setters |
| Inheritance | `SavingsAccount` & `CheckingAccount` extend `Account` |
| Polymorphism | `monthEndProcess()` behaves differently per account type |
| Exception Handling | Custom error messages for invalid operations |

## 🛠️ Technologies
- Java 17+
- CLI-based (no framework)
- Modular folder structure

## 🚀 Run
```bash
javac com/example/bank/**/*.java
java com.example.bank.BankApp
```
