package com.banking_system.BANKING_SYSTEM1.controller;

import com.banking_system.BANKING_SYSTEM1.entity.User;
import com.banking_system.BANKING_SYSTEM1.services.adminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminController {
    @Autowired
    adminModuleService adminModuleService;

    @GetMapping("/allUser")
    public ArrayList<ArrayList<User>>getAllUSers(){
        return adminModuleService.getUsers();
    }
    @GetMapping("/deleteAcc")
    public String deleteAccount(@RequestBody User user){

    }
}
