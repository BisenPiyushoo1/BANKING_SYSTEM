package com.banking_system.BANKING_SYSTEM1.repository;

import com.banking_system.BANKING_SYSTEM1.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OTP,Long> {
    Optional<OTP> findByEmail(String email);
    void deleteByEmail(String email);

}
