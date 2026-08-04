package com.banking_system.BANKING_SYSTEM1.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")

@CrossOrigin("*")
public class BankAccountController {

    @PostMapping("/create")
    public String Account(RequestBody  AccountCreateDTO  ){

        return "hello world";
    }




}
