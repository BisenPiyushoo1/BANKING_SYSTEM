package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id"
    )
    private Customers customers;

    @Column(unique = true)
    private Long accountNumber;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name="account_type")
    private AccountType accountType;


    @Enumerated(EnumType.STRING)
    @Column(name="account_status")
    private AccountStatus accountStatus;

    private Timestamp createdAt;





    public Accounts() {
    }



    public Long getAccountId() {
        return id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
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


}
