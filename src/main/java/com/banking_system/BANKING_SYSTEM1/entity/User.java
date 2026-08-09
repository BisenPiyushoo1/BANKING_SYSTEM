package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;



import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;


    @Column(name = "username")
    private String userName;


    @Column(unique = true, nullable = false)
    private String email;
    private String password;


    @Enumerated(EnumType.STRING)

    private Role role;

    private boolean verify; // true after otp come

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    public User(LocalDateTime created_at, String email, Long id, String password, Role role, String userName, boolean verify) {
        this.created_at = created_at;
        this.email = email;
        this.id = id;
        this.password = password;
        this.role = role;
        this.userName = userName;
        this.verify = verify;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public User() {
    }
}



