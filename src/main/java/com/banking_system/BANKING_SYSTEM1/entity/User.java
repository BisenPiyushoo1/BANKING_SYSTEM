package com.banking_system.BANKING_SYSTEM1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}




