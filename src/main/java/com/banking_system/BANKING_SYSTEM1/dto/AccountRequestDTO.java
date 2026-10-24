package com.banking_system.BANKING_SYSTEM1.dto;

import com.banking_system.BANKING_SYSTEM1.entity.AccountType;
import jakarta.validation.constraints.NotBlank;


public class AccountRequestDTO {

    @NotBlank(message = "Account Type is required")
    AccountType accountType;

    public @NotBlank(message = "Account Type is required") AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(@NotBlank(message = "Account Type is required") AccountType accountType) {
        this.accountType = accountType;
    }
}
