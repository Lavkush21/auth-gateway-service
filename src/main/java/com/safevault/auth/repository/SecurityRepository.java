package com.safevault.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safevault.auth.entity.UserCredentials;
import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<UserCredentials, Long> {
    
   
    Optional<UserCredentials> findByUsername(String username);
}
