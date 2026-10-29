package com.safevault.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safevault.auth.entity.UserCredentials;
import com.safevault.auth.repository.SecurityRepository;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenGeneratorService {

    @Autowired
    private SecurityRepository securityRepository;

    public String authenticateAndGenerateToken(String username, String rawPassword) {
        return securityRepository.findByUsername(username)
            .map(user -> {
                user.setTokenIssuedTime(LocalDateTime.now());
                securityRepository.save(user);
                return "VAULT-TOKEN-" + UUID.randomUUID().toString().toUpperCase();
            })
            .orElse("INVALID_CREDENTIALS");
    }
}
