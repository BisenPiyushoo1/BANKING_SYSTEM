package com.banking_system.BANKING_SYSTEM1.controller;


import com.banking_system.BANKING_SYSTEM1.dto.AccountResponseDTO;
import com.banking_system.BANKING_SYSTEM1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import com.banking_system.BANKING_SYSTEM1.dto.AccountRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")

@CrossOrigin("*")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO requestDTO, Authentication authentication){

        String email=authentication.getName();

        AccountResponseDTO responseDTO=accountService.createAccount(requestDTO,email);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);


    }




}
