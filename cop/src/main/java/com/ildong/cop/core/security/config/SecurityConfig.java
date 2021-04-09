package com.ildong.cop.core.security.config;

import com.ildong.cop.core.security.application.CopUserService;
import com.ildong.cop.core.security.infrastructure.CopAuthenticationProvider;
import com.ildong.cop.core.security.infrastructure.CopUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CopAuthenticationProvider copAuthenticationProvider;
    private CopUserService copUserService;

    public SecurityConfig(CopAuthenticationProvider copAuthenticationProvider, CopUserService copUserService) {
        this.copAuthenticationProvider = copAuthenticationProvider;
        this.copUserService = copUserService;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**","/css/**","/js/**","/domain/**","/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.csrf().disable()
            //.cors().and()
            .authorizeRequests()
                .antMatchers("/api/test").permitAll()
                .antMatchers("/api/login","/api/login-fail").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/api/login")
                .successHandler((request, response, authentication)->{
                    response.sendRedirect("/api/index");
                })
                .failureHandler((request, response, exception)->{
                    response.sendRedirect("/api/login-fail");
                })
                .and()
            .logout()
                .logoutSuccessHandler((request, response, authentication)->{
                    response.sendRedirect("/api/login");
                })
            ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(copAuthenticationProvider);
    }
}
