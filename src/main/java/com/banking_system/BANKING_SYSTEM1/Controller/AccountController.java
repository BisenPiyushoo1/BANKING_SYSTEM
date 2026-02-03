package com.banking_system.BANKING_SYSTEM1.Controller;

import com.banking_system.BANKING_SYSTEM1.models.BalanceResponse;
import com.banking_system.BANKING_SYSTEM1.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")

@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/balance")
    public BalanceResponse getBalance() {
        return new BalanceResponse(accountService.getBalance());
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam int amount) {
        accountService.deposit(amount);
        return "Deposit successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amount) {
        return accountService.withdraw(amount);
    }
}
