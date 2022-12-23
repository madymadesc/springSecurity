package com.security.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloRestController {


    @GetMapping
    public String home(){
        return "Hello, World";
    }
    @GetMapping("user")
    public String helloUser(){
        return "Hello, User";
    }

    @GetMapping("admin")
    public String helloAdmin(){
        return "Hello, Admin";
    }

}
