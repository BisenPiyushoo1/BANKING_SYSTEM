package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @Column()
    int id ;



}
