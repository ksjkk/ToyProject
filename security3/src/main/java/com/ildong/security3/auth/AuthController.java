package com.ildong.security3.auth;

import com.ildong.security3.user.UserDto;
import com.ildong.security3.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login-check")
    public String loginCheck(UserDto userDto, Model model){
        if(!userDto.getPassword().equals("123")){
            System.out.println(" 틀림 ");
            model.addAttribute("error","틀렷다");
            return "login";
        }
        return "index";
    }

    @PostMapping(value = "/login")
    public String save(UserDto userDto){
        userService.save(userDto);
        System.out.println("userDto = "+userService.store.get(userDto.getUsername()).toString());

        if(!userService.findByUsername(userDto.getUsername()).getUsername().isBlank()){
            return "index";
        }
        return "err";
    }
}
