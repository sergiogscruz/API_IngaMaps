package com.tourism.tourism.auth;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {
    public String generateToken(String username, String password) {
        return "Basic " + new String(Base64.getEncoder().encode((username + ":" + password).getBytes()));
    }
}
