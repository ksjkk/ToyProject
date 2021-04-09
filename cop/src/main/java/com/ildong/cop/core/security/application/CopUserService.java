package com.ildong.cop.core.security.application;

import com.ildong.cop.core.security.domain.CopUser;
import com.ildong.cop.core.security.infrastructure.CopUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CopUserService implements UserDetailsService {

    private CopUserRepository copUserRepository;
    @Autowired
    public CopUserService(CopUserRepository copUserRepository) {
        this.copUserRepository = copUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return copUserRepository.findOneWithAuthoritiesByUsername(username).get();
    }
}
