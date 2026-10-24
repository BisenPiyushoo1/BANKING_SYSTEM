package com.banking_system.BANKING_SYSTEM1.services;

import com.banking_system.BANKING_SYSTEM1.Exception.BadCredentialsException;
import com.banking_system.BANKING_SYSTEM1.Exception.UsernameNotFoundException;
import com.banking_system.BANKING_SYSTEM1.dto.LoginRequest;
import com.banking_system.BANKING_SYSTEM1.dto.RegisterRequest;
import com.banking_system.BANKING_SYSTEM1.entity.Customers;
import com.banking_system.BANKING_SYSTEM1.entity.OTP;
import com.banking_system.BANKING_SYSTEM1.entity.Role;
import com.banking_system.BANKING_SYSTEM1.helper.jwtUtil;
import com.banking_system.BANKING_SYSTEM1.entity.User;
import com.banking_system.BANKING_SYSTEM1.repository.CustomersRepository;
import com.banking_system.BANKING_SYSTEM1.repository.OtpRepository;
import com.banking_system.BANKING_SYSTEM1.repository.UserRepository;
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
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    EmailService emailService;

    public void register(RegisterRequest request){



        //DTO to ENTITY
        User user=new User();
        user.setUserName(request.getUserName());
        user.setRole(Role.USER); // by default role user
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setVerify(false);
        user.setCreated_at(LocalDateTime.now());

        Customers customers=new Customers();
        customers.setUser(user);
        customers.setCreatedAt(LocalDateTime.now());
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }





        userRepository.save(user);
        customersRepository.save(customers);

    }
    public String login(LoginRequest request){
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("username not found"));


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new BadCredentialsException("invalid credentials");

        }

        return jwtUtil.generateToken(request.getEmail());

    }

    public String sendOtp(String email){
        otpRepository.deleteByEmail(email);
        SecureRandom random=new SecureRandom();
        int otp=random.nextInt(9000)+1000;
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1);
        OTP otpEntity=new OTP();
        otpEntity.setOtp(otp);
        otpEntity.setEmail(email);
        otpEntity.setExpiryTime(expiryTime);
        otpRepository.save(otpEntity);
        return emailService.sendEmail(email,"verification Code",String.valueOf(otp));

    }
    public String verify(int otp,String email) {
        Optional<OTP> Otp = otpRepository.findByEmail(email);
        if (Otp.isEmpty()) {
            return "user not found";

        }
        OTP otpEntity = Otp.get();
        if (otpEntity.getExpiryTime().isBefore(LocalDateTime.now())) {
            return "otp expired";

        }
        if(otpEntity.getOtp()!=otp){
            return "Invalid Otp";
        }
        otpRepository.delete(otpEntity);


        return " otp verified successfully";
    }
    public String resetPassword(String password,String repassword){

        return "";
    }
}
