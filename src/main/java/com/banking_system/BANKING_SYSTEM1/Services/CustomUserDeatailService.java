package com.banking_system.BANKING_SYSTEM1.Services;

import com.banking_system.BANKING_SYSTEM1.Entity.User;
import com.banking_system.BANKING_SYSTEM1.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDeatailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
     @Override
     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         User user=userRepository.findByEmail(email)
                 .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

         return org.springframework.security.core.userdetails.User
                 .withUsername(user.getEmail())
                 .password(user.getPassword())
                 .roles(user.getRole().name())
                 .build();

     }
}
