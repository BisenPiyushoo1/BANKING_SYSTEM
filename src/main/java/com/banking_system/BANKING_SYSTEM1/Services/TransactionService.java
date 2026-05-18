package com.banking_system.BANKING_SYSTEM1.Services;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private int balance = 5000; // initial balance

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public String withdraw(int amount) {
        if (amount > balance) {
            return "Insufficient balance";
        }
        balance -= amount;
        return "Withdrawal successful";
    }

}
