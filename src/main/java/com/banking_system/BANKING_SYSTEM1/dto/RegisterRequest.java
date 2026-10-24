package com.banking_system.BANKING_SYSTEM1.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {



    @NotBlank(message = "username is required")
    private String userName;

    @NotBlank(message = "Email is required")
    @Email(message = "invalid email")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;


    @NotBlank(message = "required")
    private String verify_password;

    public @NotBlank(message = "Email is required") @Email(message = "invalid email") String getEmail() {
        return email;
    }


}
