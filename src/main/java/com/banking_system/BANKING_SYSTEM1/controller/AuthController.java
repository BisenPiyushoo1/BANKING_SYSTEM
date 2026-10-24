package com.banking_system.BANKING_SYSTEM1.controller;

import com.banking_system.BANKING_SYSTEM1.dto.LoginRequest;
import com.banking_system.BANKING_SYSTEM1.dto.RegisterRequest;
import com.banking_system.BANKING_SYSTEM1.dto.UserRequestDTO;
import com.banking_system.BANKING_SYSTEM1.services.AuthServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    AuthServices authServices;




    // step1
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest user){
        authServices.register(user);


        return ResponseEntity.ok("Valid");

    }
    //step 2
    @PostMapping("/login")
    public ResponseEntity<?> login( @Valid @RequestBody LoginRequest request){
        String token =authServices.login(request);
        return ResponseEntity.ok(token);

    }
    //step 3
    @PostMapping("/Send-otp")
    public String sendOtp(@RequestParam String email){
        return authServices.sendOtp(email);

    }
    //step 4
    @PostMapping("/verifyOtp")
    public String verifyOtp( @RequestParam int otp,
                             @RequestParam String email){
        return authServices.verify(otp,email);
    }


    @PostMapping("/forget-password")
    public String forgetPassword(@RequestBody String password){
        return "password Successfully changed";
    }

    @PostMapping("resetPassword")
    public String resetPassword(String password, String repassword){
        System.out.println("reset password successfullyy");
        return authServices.resetPassword(password,repassword);
    }






}
