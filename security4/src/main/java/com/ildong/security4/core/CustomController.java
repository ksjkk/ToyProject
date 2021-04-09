package com.ildong.security4.core;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomController {

    @GetMapping("/ibsheet")
    public String ibsheet(){
        return "fragments/ibsheet/theme/ibsheet";
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal User user){
        try{
            System.out.println(user  == null);
            System.out.println(user.getUsername());
        }
        catch (Exception e){
            System.out.println("e : "+e.getMessage());
        }
        return "hello";
    }

    @GetMapping("/info")
    @ResponseBody
    public String info(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get().getAuthority());
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request, HttpServletResponse response){
        return "fileUpload1";
    }
}
