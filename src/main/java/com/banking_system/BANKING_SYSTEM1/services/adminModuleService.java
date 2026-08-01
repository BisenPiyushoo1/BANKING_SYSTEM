package com.banking_system.BANKING_SYSTEM1.services;

import com.banking_system.BANKING_SYSTEM1.entity.User;
import com.banking_system.BANKING_SYSTEM1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminModuleService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {

        return userRepository.findAll();
    }
}
