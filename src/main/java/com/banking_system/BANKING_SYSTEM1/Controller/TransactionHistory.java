package com.banking_system.BANKING_SYSTEM1.Controller;


import com.banking_system.BANKING_SYSTEM1.Services.AccountService;
import com.banking_system.BANKING_SYSTEM1.Services.TransactionService;
import com.banking_system.BANKING_SYSTEM1.models.BalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionHistory {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/balance")
    public BalanceResponse getBalance() {
        return new BalanceResponse(transactionService.getBalance());
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam int amount) {
        transactionService.deposit(amount);
        return "Deposit successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amount) {
        return transactionService.withdraw(amount);
    }
}
