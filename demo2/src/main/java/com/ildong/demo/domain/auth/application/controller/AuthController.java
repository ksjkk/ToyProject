package com.ildong.demo.domain.auth.application.controller;

import com.ildong.auth.infra.AuthService;
import com.ildong.demo.domain.auth.domain.User;
import com.ildong.demo.domain.auth.domain.UserService;
import com.ildong.demo.domain.auth.dto.LoginDto;
import com.ildong.demo.domain.auth.dto.TokenDto;
import com.ildong.demo.global.security.jwt.JwtFilter;
import com.ildong.demo.global.security.jwt.JwtTokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    public AuthController(JwtTokenProvider jwtTokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) throws Exception {

        AuthService authService = new AuthService();
        if(!authService.adLogin(loginDto.getUsername(),loginDto.getPassword())){
            throw new AccountNotFoundException("로그인 정보가 잘못되었습니다.");
        }

        userService.signup(loginDto);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody LoginDto loginDto, HttpServletResponse response) throws IOException {
        User user = User.builder().build();
        try{
            user = userService.register(loginDto);
        }
        catch (Exception e){
            // 있으면 409
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
        finally {
            return user;
        }
    }
}
