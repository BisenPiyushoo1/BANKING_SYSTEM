package com.banking_system.BANKING_SYSTEM1.Repo;

import com.banking_system.BANKING_SYSTEM1.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    <Optional>Account findByAccountId(Long Account);
}
