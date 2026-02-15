package com.banking_system.BANKING_SYSTEM1.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "username")
    private String userName;


    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // ✅ Required by JPA
    public User() {
    }

    // optional constructor
    public User(String userName, int age, String email) {
        this.userName = userName;
        this.password =password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
