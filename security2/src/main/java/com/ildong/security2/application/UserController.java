package com.ildong.security2.application;

import com.ildong.security2.domain.UserInfo;
import com.ildong.security2.domain.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @GetMapping(value = "/")
    public String main(Model model) {
        List<UserInfo> lists = userService.findAll();
//        lists.sort(new Comparator<UserInfo>() {
//            @Override
//            public int compare(UserInfo o1, UserInfo o2) {
//                Long o1Code = o1.getCode();
//                Long o2Code = o2.getCode();
//                return (int)(o1Code-o2Code);
//            }
//        });
        lists.sort((UserInfo o1, UserInfo o2) -> {
            Long o1Code = o1.getCode();
            Long o2Code = o2.getCode();
            return (int)(o2Code-o1Code);
        });
        model.addAttribute("lists",lists);
        return "main";
    }

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
