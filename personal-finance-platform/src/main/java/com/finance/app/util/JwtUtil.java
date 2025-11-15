package com.finance.app.util;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import java.security.Signature;
import java.util.Date;

@Component
public class JwtUtil {

    //Header = algorithm info, Payload = user info + timestamps, Signature = verification hash made using secret key.
    private final Key SECRET_KEY =
            Keys.hmacShaKeyFor("x7G9tPqY2vS3wN7kL5a9B0eR8uT4yQ1mH7J9kD6fP2uG4vX3rE9wQ6tL8pM2bR0".getBytes());

    public String generateToken(String email){
      return Jwts.builder()
              .setSubject(email)
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis()+86400000)) //1day
              .signWith(SECRET_KEY)
              .compact();
    }
}
