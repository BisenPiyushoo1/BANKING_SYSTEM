package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;

import java.time.LocalDateTime;


@Entity
@Table(name="transactions")
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trans_id")
    private Long id ;

    @ManyToOne
    @JoinColumn(name="account_id" ,referencedColumnName = "id")
    private Accounts accounts;


    @Enumerated(EnumType.STRING)
    @Column(name="trans_type")
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "trans_status")
    private TransactionStatus transactionStatus;


    private BigDecimal amount;

    private BigDecimal balance_after;

    @Column(unique = true)
    private Long reference_number;

    private String description;

    private LocalDateTime trans_date;

    public Transactions() {
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance_after() {
        return balance_after;
    }

    public void setBalance_after(BigDecimal balance_after) {
        this.balance_after = balance_after;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReference_number() {
        return reference_number;
    }

    public void setReference_number(Long reference_number) {
        this.reference_number = reference_number;
    }

    public LocalDateTime getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(LocalDateTime trans_date) {
        this.trans_date = trans_date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Transactions(Accounts accounts, BigDecimal amount, BigDecimal balance_after, String description, Long id, Long reference_number, LocalDateTime trans_date, TransactionType transactionType, TransactionStatus transactionStatus) {
        this.accounts = accounts;
        this.amount = amount;
        this.balance_after = balance_after;
        this.description = description;
        this.id = id;
        this.reference_number = reference_number;
        this.trans_date = trans_date;
        this.transactionType = transactionType;
        this.transactionStatus=transactionStatus;
    }
}
