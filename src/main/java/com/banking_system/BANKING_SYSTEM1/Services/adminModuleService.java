package com.banking_system.BANKING_SYSTEM1.Services;

import com.banking_system.BANKING_SYSTEM1.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class adminModuleService {

    public ArrayList<ArrayList<User>> getUsers(){
        return new ArrayList<ArrayList<User>>();
    }
}
