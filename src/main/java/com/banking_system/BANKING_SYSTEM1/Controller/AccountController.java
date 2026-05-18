package com.banking_system.BANKING_SYSTEM1.Controller;//🚀 MUST-HAVE Advanced Features
//        1. 🔐 Advanced Security (Game Changer)
//        JWT + Refresh Token
//        Role-Based Access Control (RBAC)
//        Account locking after failed attempts
//        API rate limiting (prevent brute force)
//        Password encryption (BCrypt)
//
//        👉 Ye part strong hua → shortlist chances 📈
//
//        2. 💸 Transaction System (REAL BANK LOGIC)
//        Atomic transactions (no money loss)
//        Double-entry system (debit + credit)
//        Idempotency (same request repeat → duplicate transfer na ho)
//
//        👉 Ye interview me poocha hi poocha jayega
//
//        3. ⚡ Event-Driven Architecture (BIG LEVEL)
//
//        Use message broker:
//
//        Apache Kafka OR RabbitMQ
//
//        Use cases:
//
//        Transaction → event publish
//        Notification service consume kare
//        Fraud detection async chale
//
//        👉 Ye laga diya → tu fresher nahi, backend engineer lagta hai
//
//        4. 🧠 Fraud Detection (Unique Feature)
//        Suspicious activity detection:
//        same IP multiple transfers
//        large amount alerts
//        Simple rule engine bana
//
//        👉 Ye sabse rare feature hai resume me
//
//        5. 📊 Audit Logging System
//        Har transaction log karo
//        Who did what & when
//
//        👉 Production systems me mandatory hota hai
//
//        6. 🔄 Microservices Architecture (Optional but Powerful)
//
//        Split:
//
//        User Service
//        Transaction Service
//        Notification Service
//        7. ☁️ Deployment (MOST IMPORTANT)
//        Docker use karo → Docker
//        Cloud pe deploy karo (AWS free tier)
//
//        👉 Agar deploy nahi kiya → project aadha hi maana jayega
//
//        8. 🧪 Testing (90% log skip karte hain)
//        Unit tests
//        API testing
//        🏗️ Tech Stack (Resume ke liye perfect)
//        Spring Boot
//        Spring Security
//        JPA + MySQL
//        Kafka / RabbitMQ
//        Redis (caching)
//        Docker
//        AWS (EC2 / RDS)
//        📦 Final Output kya hona chahiye?
//
//        GitHub repo me:
//
//        Clean folder structure
//        README me:
//        Architecture diagram
//        Features list
//        API endpoints
//DAY 1 — Project Setup + Base Structure
//Spring Boot project create
//Dependencies:
//Web
//        JPA
//MySQL
//        Lombok
//Packages:
//controller / service / repository / entity / dto / config
//
//✅ Output: Project runs + clean structure
//
//🗓️ DAY 2 — User & Account Entity
//User entity (id, name, email, password, role)
//Account entity (id, balance, user_id)
//One-to-many relation
//
//✅ Output: DB tables created
//
//🗓️ DAY 3 — Basic APIs
//Create User
//Create Account
//Get Account Details
//
//👉 No security yet
//
//🗓️ DAY 4 — Deposit & Withdraw (Core Logic)
//Deposit API
//Withdraw API
//Balance update
//
//⚠️ Validation:
//
//No negative balance
//🗓️ DAY 5 — Transaction History
//Transaction entity:
//type (DEBIT/CREDIT)
//amount
//        timestamp
//API: Get transaction history
//🗓️ DAY 6 — Exception Handling
//Global Exception Handler
//Custom exceptions:
//UserNotFound
//        InsufficientBalance
//
//👉 Clean API responses
//
//🗓️ DAY 7 — JWT Authentication 🔐
//Login API
//Generate JWT
//Validate token
//
//👉 Flow samajh:
//Login → Token → Request with token
//
//🗓️ DAY 8 — RBAC (Role-Based Access)
//Roles: USER / ADMIN
//Secure endpoints:
//Admin only APIs
//User APIs
//🗓️ DAY 9 — Spring Security Filter Chain
//Custom JWT filter
//Add filter in security config
//
//👉 Ye wahi part hai jahan tu bol raha tha confidence low hai —
//yahin practice milegi
//
//🗓️ DAY 10 — Money Transfer (IMPORTANT 💸)
//Transfer API:
//fromAccount → toAccount → amount
//
//⚠️ Must:
//
//Atomic transaction (@Transactional)
//Both debit & credit
//🗓️ DAY 11 — Idempotency (ADVANCED ⭐)
//Same request repeat → duplicate transfer na ho
//Use unique transactionId
//
//👉 Interview me ye bol diya = strong impression
//
//🗓️ DAY 12 — Event System (Big Level 🚀)
//
//Use:
//        👉 Apache Kafka
//
//Transaction → event publish
//Consumer:
//Notification (console log/email simulation)
//🗓️ DAY 13 — Redis Caching ⚡
//
//Use:
//        👉 Redis
//
//Cache account details
//Improve performance
//🗓️ DAY 14 — Docker + Deployment ☁️
//
//Use:
//        👉 Docker
//
//Dockerize app
//Run with container
//        (Optional) Deploy on AWS
//🗓️ DAY 15 — Final Polish (VERY IMPORTANT)
//README file:
//Features
//Architecture diagram
//Postman collection
//Clean code
//GitHub push
//Postman collectionpackage com.banking_system.BANKING_SYSTEM1.Controller;

import com.banking_system.BANKING_SYSTEM1.models.BalanceResponse;
import com.banking_system.BANKING_SYSTEM1.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")

@CrossOrigin("*")
public class AccountController {


}
