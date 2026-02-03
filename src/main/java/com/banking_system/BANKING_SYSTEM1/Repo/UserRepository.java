package com.banking_system.BANKING_SYSTEM1.Repo;

import com.banking_system.BANKING_SYSTEM1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
