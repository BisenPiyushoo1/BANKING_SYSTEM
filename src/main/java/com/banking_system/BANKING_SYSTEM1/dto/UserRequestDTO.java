package com.banking_system.BANKING_SYSTEM1.dto;


import java.time.LocalDate;

public class UserRequestDTO {
    String username;
    String email;
    String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public UserRequestDTO(String email, String password, String username) {
        this.email = email;

        this.password = password;
        this.username = username;
    }


}
