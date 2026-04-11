package com.banking_system.BANKING_SYSTEM1.Helper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;

@Component
public class jwtUtil {
    @Value("${jwt.secret}")
    private  String SECRER_KEY_STRING;
    @Value("${jwt.expiration}")
    private Long expiration;
    private  Key SECRET_KEY () {
        return Keys.hmacShaKeyFor(SECRER_KEY_STRING.getBytes());
    }


    public String generateToken(String username){
        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SECRET_KEY())
                .compact();
        return token;
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(SECRET_KEY()).build().parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException e){
            System.out.println("Token is expired"+e.getMessage());
            return false;
        }
    }
}
