package com.codingshuttle.linkedin.api_gateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

}

//Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiZW1haWwiOiJzYW03NzhAZ21haWwuY29tIiwiaWF0IjoxNzYzODI3MzA3LCJleHAiOjE3NjM4Mjc5MDd9.QMmPj6GNA2i7Fwjy_7AEZS4HLF4VGpWAdnuDHgLtzJxPlLIqFn4IpSdyBwQfGGjQmc7RaEIe7N07aOvQHO0mIw
