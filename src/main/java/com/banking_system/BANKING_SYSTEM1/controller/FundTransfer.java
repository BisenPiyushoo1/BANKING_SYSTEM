package com.banking_system.BANKING_SYSTEM1.controller;

import com.banking_system.BANKING_SYSTEM1.dto.fundTransferRequestDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/fund-transfer")
@RestController
public class FundTransfer {


    @PostMapping("/send")
    public void SendMoney(@RequestBody fundTransferRequestDto details){



    }
}
