package com.security.spring;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // TODO configure authentication manager
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // TODO configure web security
//    }
}