package com.banking_system.BANKING_SYSTEM1.Services;

import com.banking_system.BANKING_SYSTEM1.Entity.OTP;
import com.banking_system.BANKING_SYSTEM1.Entity.Role;
import com.banking_system.BANKING_SYSTEM1.Helper.jwtUtil;
import com.banking_system.BANKING_SYSTEM1.Entity.User;
import com.banking_system.BANKING_SYSTEM1.Repo.OtpRepository;
import com.banking_system.BANKING_SYSTEM1.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class AuthServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    jwtUtil jwtUtil;
    @Autowired
    OtpRepository otpRepository;

    public String register(String username,String email, String password){
        Optional<User> existence = userRepository.findByEmail(email);

        if (existence.isPresent()) {
            return "User Already Exist";
        }
        //DTO to ENTITY
        User user=new User();
        user.setUserName(username);
        user.setRole(Role.USER); // by default role user
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));


        userRepository.save(user);

        return  "registration successfully done!";
    }
    public String login(String email,String password){
        Optional<User> mail=userRepository.findByEmail(email);
        if (mail.isEmpty()){
            return "invalid credentials";
        }
        User user=mail.get();
        if (passwordEncoder.matches(password, user.getPassword())){
            return jwtUtil.generateToken(email);
        }

        return "invalid credentials";

    }

    public int sendOtp(String email){
        otpRepository.deleteByEmail(email);
        SecureRandom random=new SecureRandom();
        int otp=random.nextInt(9000)+1000;
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1);
        OTP otpEntity=new OTP();
        otpEntity.setOtp(otp);
        otpEntity.setEmail(email);
        otpEntity.setExpiryTime(expiryTime);
        otpRepository.save(otpEntity);
        return otp;

    }
    public String verify(int otp,String email) {
        Optional<OTP> Otp = otpRepository.findByEmail(email);
        if (Otp.isEmpty()) {
            return "user not found";

        }
        OTP otpEntity = Otp.get();
        if (otpEntity.getExpiryTime().isBefore(LocalDateTime.now())) {

        }


        return " verified successfully";
    }
}
