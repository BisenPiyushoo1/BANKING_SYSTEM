package com.banking_system.BANKING_SYSTEM1.repository;

import com.banking_system.BANKING_SYSTEM1.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
