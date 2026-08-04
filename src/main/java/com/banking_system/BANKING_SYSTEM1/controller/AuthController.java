package com.banking_system.BANKING_SYSTEM1.controller;

import com.banking_system.BANKING_SYSTEM1.dto.LoginRequest;
import com.banking_system.BANKING_SYSTEM1.dto.UserRequestDTO;
import com.banking_system.BANKING_SYSTEM1.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    AuthServices authServices;


    //step 1
    @PostMapping("/Send-otp")
    public int sendOtp(@RequestParam String email){
        return authServices.sendOtp(email);

    }

    @PostMapping("/register")
    public String register(@RequestBody UserRequestDTO user){
        System.out.println(" succesfully register");
        return authServices.register(user.getUsername(), user.getEmail(), user.getPassword());

    }
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest request){
        System.out.println("LOGIN API HIT");
        String token =authServices.login(request.getEmail(),request.getPassword());
        Map<String,String>response=new HashMap<>();
        response.put("token",token);
        return response;

    }
    @PostMapping("/verifyOtp")
    public String verifyOtp(int otp,String email){
        return authServices.verify(otp,email);
    }

    @PostMapping("/forget-password")
    public String forgetPassword(@RequestBody String password){
        return "password Successfully changed";
    }

    @PostMapping("resetPassword")
    public String resetPassword(String password, String repassword){
        System.out.println("reset password successfully");
        return authServices.resetPassword(password,repassword);
    }






}
