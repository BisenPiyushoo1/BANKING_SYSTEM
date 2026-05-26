package com.banking_system.BANKING_SYSTEM1.services;

import com.banking_system.BANKING_SYSTEM1.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class adminModuleService {

    public ArrayList<ArrayList<User>> getUsers(){
        return new ArrayList<ArrayList<User>>();
    }
}
