package com.ildong.demo.domain.auth.domain;

import com.ildong.demo.domain.auth.dto.LoginDto;
import com.ildong.demo.global.security.util.SecurityUtil;
import com.ildong.demo.infrastructure.repository.auth.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(LoginDto loginDto) throws Exception{
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        Set<Authority> authoritySet = Collections.singleton(authority);
        try {
            User findUser = userRepository.findOneWithAuthoritiesByUsername(loginDto.getUsername()).get();
            authoritySet = findUser.getAuthorities();
        }
        catch (Exception e){
            // user not found in db
        }
        finally {
            User user = User.builder()
                    .username(loginDto.getUsername())
                    .password(passwordEncoder.encode(loginDto.getPassword()))
                    .authorities(authoritySet)
                    .activated("1")
                    .build();
            return userRepository.save(user);
        }
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }

    public User register(LoginDto loginDto) {
        if(userRepository.findOneWithAuthoritiesByUsername(loginDto.getUsername()).orElse(null) != null){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        try {
            return signup(loginDto);
        }
        catch (Exception e){
            throw new RuntimeException("회원가입에 실패했습니다.");
        }
    }
}
