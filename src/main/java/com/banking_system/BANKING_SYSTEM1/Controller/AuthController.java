package com.banking_system.BANKING_SYSTEM1.Controller;

import com.banking_system.BANKING_SYSTEM1.DTO.LoginRequest;
import com.banking_system.BANKING_SYSTEM1.DTO.UserRequestDTO;
import com.banking_system.BANKING_SYSTEM1.Services.AccountService;
import com.banking_system.BANKING_SYSTEM1.Services.AuthServices;
import com.banking_system.BANKING_SYSTEM1.Services.OtpService;
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
        String token =authServices.login(request.getEmail(),request.getPassword());
        Map<String,String>response=new HashMap<>();
        response.put("token",token);
        return response;

    }
    @PostMapping("/verifyOtp")
    public String verifyOtp(int otp,String email){
        return authServices.verify(otp,email);
    }






}
