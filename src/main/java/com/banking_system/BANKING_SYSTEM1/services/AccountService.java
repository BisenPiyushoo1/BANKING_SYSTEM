package com.banking_system.BANKING_SYSTEM1.services;
import com.banking_system.BANKING_SYSTEM1.dto.AccountRequestDTO;
import com.banking_system.BANKING_SYSTEM1.dto.AccountResponseDTO;
import com.banking_system.BANKING_SYSTEM1.entity.AccountStatus;
import com.banking_system.BANKING_SYSTEM1.entity.Accounts;
import com.banking_system.BANKING_SYSTEM1.entity.Customers;
import com.banking_system.BANKING_SYSTEM1.entity.User;
import com.banking_system.BANKING_SYSTEM1.repository.AccountRepository;
import com.banking_system.BANKING_SYSTEM1.repository.CustomersRepository;
import com.banking_system.BANKING_SYSTEM1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.security.SecureRandom;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomersRepository customersRepository;

    private final SecureRandom secureRandom = new SecureRandom();

    private Long generateAccountNumber() {
        return 100_000_000_000L
                + secureRandom.nextLong(900_000_000_000L);
    }

    public AccountResponseDTO createAccount(AccountRequestDTO request, String email){
        Customers customer = customersRepository
                .findByUser_Email(email)
                .orElseThrow(() ->
                        new RuntimeException("Customer profile not found"));



        if (accountRepository.existsByCustomers_Id(customer.getId())) {
            throw new RuntimeException(
                    "Bank account already exists for this customer");
        }


        Accounts account = new Accounts();
        account.setCustomers(customer);
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setCreatedAt(
                new java.sql.Timestamp(System.currentTimeMillis()));

        Accounts savedAccount = accountRepository.save(account);

        User user = customer.getUser();

        return new AccountResponseDTO(
                user.getUserName(),
                user.getEmail(),
                savedAccount.getAccountNumber(),
                savedAccount.getAccountType(),
                savedAccount.getBalance(),
                savedAccount.getAccountStatus(),
                savedAccount.getCreatedAt()
        );


    }










}
