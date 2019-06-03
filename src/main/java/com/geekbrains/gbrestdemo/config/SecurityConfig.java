package com.geekbrains.gbrestdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("alex").password("{noop}100").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("bob").password("{bcrypt}$2a$04$U5SSVd.banv0IstldZPvluunT7Ut4m45NUa2y1N5/XJwgZlDX9BIS").roles("USER1");
        auth.inMemoryAuthentication().withUser("bob2").password("{noop}101").roles("USER2");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("ADMIN", "USER1", "USER2")
                .antMatchers("/api/books/**").hasAnyRole("USER1")
                .antMatchers("/api/students/**").hasAnyRole("USER2")
//                .antMatchers("/api/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().ignoringAntMatchers("/api/**");
    }
}