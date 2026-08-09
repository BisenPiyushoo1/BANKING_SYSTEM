package com.banking_system.BANKING_SYSTEM1.repository;

import com.banking_system.BANKING_SYSTEM1.entity.Account;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    <Optional>Account findByAccountId(Long Account);
}