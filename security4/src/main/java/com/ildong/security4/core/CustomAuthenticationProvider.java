package com.ildong.security4.core;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username1 = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        if(!username1.equals("218076")){
            throw new BadCredentialsException("한글");
        }
        System.out.println("username1 = " + username1);
        System.out.println("password = " + password);
        List<CustomAuthentication> authList = new ArrayList<>();
        authList.add(new CustomAuthentication("USER"));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username1,null,authList);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
