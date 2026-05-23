package com.banking_system.BANKING_SYSTEM1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/about")
    public String About(){
        return"";
    }
    @GetMapping("/contact")
    public String Contact(){
        return "6264908431";
    }

}
