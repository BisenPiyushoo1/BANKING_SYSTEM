package com.banking_system.BANKING_SYSTEM1.controller;

import com.banking_system.BANKING_SYSTEM1.entity.User;
import com.banking_system.BANKING_SYSTEM1.services.adminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    adminModuleService adminModuleService;

    @GetMapping("/allUser")
    public List<User> getAllUSers(){
        return adminModuleService.getUsers();
    }


    @GetMapping("/deleteAcc")
    public String deleteAccount(@RequestBody User user){
        return "hello worlds";

    }
}
