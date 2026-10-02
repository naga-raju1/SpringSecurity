package com.spring.SpringSecurity.service;

import com.spring.SpringSecurity.model.Users;
import com.spring.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
 public class UserService
{
    @Autowired
    private UserRepository repository;

    @Autowired
    private JWTservice jwtService;

    @Autowired
    AuthenticationManager authManager;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public  Users register(Users user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);

    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());

        }
        return "Invalid username or password";

    }
}
