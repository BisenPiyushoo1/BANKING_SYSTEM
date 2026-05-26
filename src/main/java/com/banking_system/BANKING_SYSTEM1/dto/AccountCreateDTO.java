package com.banking_system.BANKING_SYSTEM1.dto;

public class AccountCreateDTO {
     Long accountNumber;
     String balance;
     String accountType;
     Long Balance;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setBalance(Long balance) {
        Balance = balance;
    }
}
