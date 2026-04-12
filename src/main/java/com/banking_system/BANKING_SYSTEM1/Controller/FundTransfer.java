package com.banking_system.BANKING_SYSTEM1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fund-transfer")
@RestController
public class FundTransfer {

    @PostMapping("/send")
    public void SendMoney(@RequestParam to){

    }
}
