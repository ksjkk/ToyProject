package com.ildong.security4.core;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomAuthenticationProvider authenticationProvider;
    public SecurityConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/ibsheet").permitAll()
                .antMatchers("/info","/hello").hasRole("USER")
                .antMatchers("/api/files","/fileUpload").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("/index");
                })
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception = " + exception.getMessage());
                    response.sendRedirect("/loginFail");
                })
        ;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
