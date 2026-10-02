package com.spring.SpringSecurity.service;

import com.spring.SpringSecurity.model.UserPrincipal;
import com.spring.SpringSecurity.model.Users;
import com.spring.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Users users = repository.findByUsername(username);
         if(users == null) {
             System.out.println("Username not found");
             throw new UsernameNotFoundException("Username not found");
         }
        return new UserPrincipal(users);
    }
}
