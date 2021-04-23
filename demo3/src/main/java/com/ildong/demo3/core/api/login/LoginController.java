package com.ildong.demo3.core.api.login;

import com.ildong.auth.infra.AuthService;
import com.ildong.demo3.core.api.emp.Authority;
import com.ildong.demo3.core.api.emp.Emp;
import com.ildong.demo3.core.api.emp.EmpService;
import com.ildong.demo3.core.security.jwt.JwtFilter;
import com.ildong.demo3.core.security.jwt.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final JwtProvider jwtProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final EmpService empService;

    public LoginController(JwtProvider jwtProvider, AuthenticationManagerBuilder authenticationManagerBuilder, EmpService empService) {
        this.jwtProvider = jwtProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.empService = empService;
    }

    @PostMapping("/auth/authenticate")
    public Emp validationToken(HttpServletRequest request){
        String jwt = request.getHeader(JwtFilter.AUTHORIZATION_HEADER).substring(7);
        Authentication authentication = jwtProvider.getAuthentication(jwt);
        // authentication.getName() 과 사번을 던져서 일치하면 ㅇㅋ 하는걸로 합시다
        return empService.getUserWithAuthorities(authentication.getName()).get();
    }

    @PostMapping("/auth/login")
    public Map<String,Object> authorize(@Valid @RequestBody LoginDto loginDto, HttpServletResponse response) throws Exception {

        AuthService authService = new AuthService();
        if(!authService.adLogin(loginDto.getUsername(),loginDto.getPassword())){
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"로그인 정보가 잘못되었습니다.");
            throw new AccountNotFoundException("로그인 정보가 잘못되었습니다.");
        }

        Emp emp = empService.getUserWithAuthorities(loginDto.getUsername()).get();

        String id = emp.getId();
        Set<Authority> authorities = emp.getAuthorities();

        String jwt = jwtProvider.createToken(id,authorities);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("jwt",jwt);
        returnMap.put("userInfo",emp);
        return returnMap;
    }

    @PostMapping("/auth/logout")
    public String logout(){ return "logout"; }

    @GetMapping("/user/info/{id}")
    public Emp getUserInfo(@PathVariable String id){
        Emp empInfo = empService.getUserWithAuthorities(id).get();
        return empInfo;
    }
}
