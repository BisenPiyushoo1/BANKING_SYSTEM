package com.banking_system.BANKING_SYSTEM1.Helper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;

@Component
public class jwtUtil {
    private static  final String SECRER_KEY_STRING="piyush#1123332332@@@12212bdbchacbmafdfnfbbfjdbcdbjdjbcb";
    private final Key SECRET_KEY =
            Keys.hmacShaKeyFor(SECRER_KEY_STRING.getBytes());
    public String generateToken(String username){
        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(SECRET_KEY)
                .compact();
        return token;
    }
    public boolean validToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException e){
            System.out.println("Token is expired"+e.getMessage());
            return false;
        }
    }
}
