package com.spring.SpringSecurity.Configure;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/")
    public String greeting(HttpServletRequest request)
    {
        return "Hello Spring Security!"+ request.getSession().getId();
    }

}
