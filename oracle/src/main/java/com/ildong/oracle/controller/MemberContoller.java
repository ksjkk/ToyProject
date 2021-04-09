package com.ildong.oracle.controller;

import com.ildong.oracle.auth.PrincipalDetail;
import com.ildong.oracle.domain.Member;
import com.ildong.oracle.domain.Sessions;
import com.ildong.oracle.service.MemberService;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class MemberContoller {
    private final MemberService memberService;

    public MemberContoller(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/get-emp")
    @ResponseBody
    public Optional<Member> findByEmpno(Member member){
        return memberService.findByEmpno(member.getEmpno());
    }

    @GetMapping("/login")
    public String home(Model model, HttpServletRequest request){
        System.out.println("login page");
        model.addAttribute("data","dataValue");
        return "/member/member";
    }

    @PostMapping("/login/ad")
    public String loginAd(Member member, Model model, HttpServletRequest request){
        boolean loginCheck = memberService.loginAd(member.getEmpno(), member.getPassword());
        model.addAttribute("data",member.getEmpno());
        System.out.println(loginCheck);
        return loginCheck == true ? "/login/index" : "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,Model model){
        return "redirect:/login";
    }

    @GetMapping("/auth")
    public String auth(){
        return "/auth/auth";
    }
}
