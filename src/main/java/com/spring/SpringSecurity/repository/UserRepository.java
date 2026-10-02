package com.spring.SpringSecurity.repository;

import com.spring.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>
{
    Users findByUsername(String username);
}

// --> plain -> hash