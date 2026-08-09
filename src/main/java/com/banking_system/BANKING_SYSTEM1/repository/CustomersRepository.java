package com.banking_system.BANKING_SYSTEM1.repository;

import com.banking_system.BANKING_SYSTEM1.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Long> {

}
