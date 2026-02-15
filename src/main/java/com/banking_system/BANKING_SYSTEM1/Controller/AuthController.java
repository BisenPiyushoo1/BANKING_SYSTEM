package com.banking_system.BANKING_SYSTEM1.Controller;

import com.banking_system.BANKING_SYSTEM1.DTO.LoginRequest;
import com.banking_system.BANKING_SYSTEM1.DTO.UserRequestDTO;
import com.banking_system.BANKING_SYSTEM1.Services.AccountService;
import com.banking_system.BANKING_SYSTEM1.Services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    AuthServices authServices;

    @RequestMapping("/authentication")
    @PostMapping("/register")
    public String register(@RequestBody UserRequestDTO user){
        return authServices.register(user.getUsername(), user.getEmail(), user.getPassword());

    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authServices.login(request.getEmail(),request.getPassword());

    }






}
