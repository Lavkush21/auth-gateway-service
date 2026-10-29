package com.safevault.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.safevault.auth.service.TokenGeneratorService;

@RestController
@RequestMapping("/api/v1/secure/vault")
public class SecurityController {

    @Autowired
    private TokenGeneratorService tokenGeneratorService;

    @PostMapping("/login")
    public ResponseEntity<String> issueSecureIdentityToken(
            @RequestParam String username, 
            @RequestParam String secretKey) {
        
        String sessionToken = tokenGeneratorService.authenticateAndGenerateToken(username, secretKey);
        
        if ("INVALID_CREDENTIALS".equals(sessionToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied: Invalid Security Signature.");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(sessionToken);
    }
}
