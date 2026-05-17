package com.banking_system.BANKING_SYSTEM1.Services;

import com.banking_system.BANKING_SYSTEM1.Repo.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
    @Autowired
    private  OtpRepository otpRepository;
    public String sendOtp(String email){
        return "email Send";

    }

}
