package com.banking_system.BANKING_SYSTEM1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "email required")
    String email;
    @NotBlank(message = "password required")
    String password;


}
