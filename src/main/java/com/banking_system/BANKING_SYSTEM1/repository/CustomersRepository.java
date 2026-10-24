package com.banking_system.BANKING_SYSTEM1.repository;

import com.banking_system.BANKING_SYSTEM1.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers,Long> {
    Optional<Customers> findByUser_Email(String email);

}
