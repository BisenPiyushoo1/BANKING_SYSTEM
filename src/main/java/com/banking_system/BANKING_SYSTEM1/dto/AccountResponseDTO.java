package com.banking_system.BANKING_SYSTEM1.dto;

import com.banking_system.BANKING_SYSTEM1.entity.AccountStatus;
import com.banking_system.BANKING_SYSTEM1.entity.AccountType;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccountResponseDTO {

    private String username;
    private String email;
    private Long accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private AccountStatus accountStatus;
    private Timestamp createdAt;

    public AccountResponseDTO(
            String username,
            String email,
            Long accountNumber,
            AccountType accountType,
            BigDecimal balance,
            AccountStatus accountStatus,
            Timestamp createdAt) {

        this.username = username;
        this.email = email;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}