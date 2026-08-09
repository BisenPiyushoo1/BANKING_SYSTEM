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
    private User user;

    private Long accountNumber;

    private String balance;

    private String accountType;
    private

    private Timestamp createdAt;





    public Accounts() {
    }

    public Accounts(Long accountNumber, String accountType, String balance, User user) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
