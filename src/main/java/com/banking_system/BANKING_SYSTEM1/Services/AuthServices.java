package com.banking_system.BANKING_SYSTEM1.Services;

import com.banking_system.BANKING_SYSTEM1.Entity.Role;
import com.banking_system.BANKING_SYSTEM1.Helper.jwtUtil;
import com.banking_system.BANKING_SYSTEM1.Entity.User;
import com.banking_system.BANKING_SYSTEM1.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Service
public class AuthServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    jwtUtil jwtUtil;

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
}
