package com.ildong.cop.core.api.domain.login.application;

import com.ildong.cop.core.security.application.LoginService;
import com.ildong.cop.core.security.domain.CopUser;
import com.ildong.cop.core.security.domain.CopUserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/api")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal String username){
        return username == "anonymousUser" ? "login/login" : "redirect:/api/index";
    }

    @GetMapping("/login-fail")
    public String loginFail(Model model){
        model.addAttribute("error","계정정보가 일치하지 않습니다.");
        return "login/login";
    }

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal String username, Model model){
        String returnPath = loginService.userContextUpdate(username);
        logger.info("returnPath : " + returnPath);  // fragments/layout/index
        model.addAttribute("userInfo",CopUserContext.getInfo());
        return returnPath;
    }
}
