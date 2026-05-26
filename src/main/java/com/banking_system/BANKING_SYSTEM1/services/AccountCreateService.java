package com.banking_system.BANKING_SYSTEM1.services;

import com.banking_system.BANKING_SYSTEM1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreateService {

    @Autowired
    AccountRepository accountRepository;



}
