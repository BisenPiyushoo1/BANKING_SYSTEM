package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private Customers customers;

    private Long accountNumber;

    private String balance;

    private AccountType accountType;
    private AccountStatus accountStatus;

    private Timestamp createdAt;





    public Accounts() {
    }



    public Long getAccountId() {
        return accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers user) {
        this.customers = customers;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
