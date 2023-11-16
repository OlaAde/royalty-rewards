package org.example.royaltyrewards.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface JwtService {
    String generateToken(String email);

    String extractUserEmail(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
