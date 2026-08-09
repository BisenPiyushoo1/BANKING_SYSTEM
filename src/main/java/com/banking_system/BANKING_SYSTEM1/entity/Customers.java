package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id",unique = true)
    private User user;

    @Column(name = "first_name", length = 50)
    private String first_name;

    @Column(name = "last_name", length = 50)
    private String last_name;

    @Column(name="phone", length =15,unique = true)
    private Long phone;

    @Column(name="date_of_birth")
    private LocalDate DOB;

    @Column(name="address", length = 255)
    private String address;

    @Column(name="createdAt")
    private LocalDateTime createdAt;

    public Customers() {

    }

    public Customers(String address, LocalDateTime createdAt, LocalDate DOB, String first_name, Long id, String last_name, Long phone) {
        this.address = address;
        this.createdAt = createdAt;
        this.DOB = DOB;
        this.first_name = first_name;
        this.id = id;
        this.last_name = last_name;
        this.phone = phone;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Long getId() {
        return id;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
