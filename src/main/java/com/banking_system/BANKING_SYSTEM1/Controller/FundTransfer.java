package com.banking_system.BANKING_SYSTEM1.Controller;

import com.banking_system.BANKING_SYSTEM1.DTO.fundTransferRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/fund-transfer")
@RestController
public class FundTransfer {


    @PostMapping("/send")
    public void SendMoney(@RequestBody fundTransferRequestDto details){



    }
}
