package com.safevault.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String securedHashPassword;

    private LocalDateTime tokenIssuedTime;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getSecuredHashPassword() { return securedHashPassword; }
    public void setSecuredHashPassword(String securedHashPassword) { this.securedHashPassword = securedHashPassword; }
    public LocalDateTime getTokenIssuedTime() { return tokenIssuedTime; }
    public void setTokenIssuedTime(LocalDateTime tokenIssuedTime) { this.tokenIssuedTime = tokenIssuedTime; }
}
