package com.banking_system.BANKING_SYSTEM1.Controller;


import org.springframework.web.bind.annotation.*;
import com.banking_system.BANKING_SYSTEM1.DTO.AccountCreateDTO;

@RestController
@RequestMapping("/api/account")

@CrossOrigin("*")
public class BankAccountController {

    @PostMapping("/create")
    public String Account(RequestBody  AccountCreateDTO account ){

        return "";
    }




}
