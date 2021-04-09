package com.ildong.security.controller;

import com.ildong.security.domain.LoginForm;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/staff")
    public String getStaff(Model model){
        return "staff";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model){
        return "admin";
    }

    @GetMapping("/")
    public String getIndex(LoginForm loginForm,Model model,@AuthenticationPrincipal UserDetails user){
        System.out.println(loginForm.getPassword());
        System.out.println("user name : " + user.getUsername());
        System.out.println("user pass : " + user.getPassword());
        System.out.println("user auth : " + user.getAuthorities());
        System.out.println("user enabled : " + user.isEnabled());
        return "index";
    }

    @GetMapping("/customlogin")
    public String getCustomlogin(){
        return "customlogin";
    }
}
