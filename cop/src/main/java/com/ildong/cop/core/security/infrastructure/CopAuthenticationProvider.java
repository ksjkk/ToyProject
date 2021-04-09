package com.ildong.cop.core.security.infrastructure;

import com.ildong.auth.infra.AuthService;
import com.ildong.cop.core.security.application.CopUserService;
import com.ildong.cop.core.security.domain.CopUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CopAuthenticationProvider implements AuthenticationProvider {

    private final static Logger logger = LoggerFactory.getLogger(CopAuthenticationProvider.class);

    private CopUserService copUserService;

    public CopAuthenticationProvider(CopUserService copUserService) {
        this.copUserService = copUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        CopUser user = (CopUser)copUserService.loadUserByUsername(name);
        if(user == null){
            throw new BadCredentialsException("계정이 없습니다");
        }

        AuthService authService = new AuthService();
        if(authService.adLogin(name,password)) {
            return new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),authentication.getCredentials(),user.getAuthorities()
            );
        }
        else{
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
