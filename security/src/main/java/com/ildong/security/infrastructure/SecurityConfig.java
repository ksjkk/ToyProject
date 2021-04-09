package com.ildong.security.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/index","/customlogin").permitAll()
                .antMatchers(HttpMethod.POST,"/processlogin").permitAll()
                .antMatchers(HttpMethod.POST,"/logout").authenticated()
                .antMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/staff/**").hasAnyRole("STAFF","ADMIN")
                .anyRequest().authenticated()
                ;
//            .and()
        http
            .formLogin()
                .loginPage("/customlogin")
                .loginProcessingUrl("/processlogin")
                .defaultSuccessUrl("/")
                .usernameParameter("empno")
                .passwordParameter("password")
        ;
    }

    @Autowired
    private PasswordEncoder pe;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception{}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("staff").password(pe.encode("1234")).roles("STAFF").and()
                .withUser("admin").password(pe.encode("1234")).roles("ADMIN").and()
                .withUser("218076").password(pe.encode("dkdk184511")).roles("ADMIN")
                ;
    }
}
