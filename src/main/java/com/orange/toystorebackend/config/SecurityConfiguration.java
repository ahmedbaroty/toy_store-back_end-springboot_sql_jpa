package com.orange.toystorebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

                httpSecurity
                .authorizeRequests()
                .anyRequest()
                .permitAll() //allow all user to login
                //.authenticated() // to allow to specific users
                .and()
                //.addFilterBefore(customFilter() , BasicAuthenticationFilter.class)
                .httpBasic();
        httpSecurity.csrf().disable();
    }
}
