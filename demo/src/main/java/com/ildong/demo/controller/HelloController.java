package com.ildong.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class HelloController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(Model model){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("msg", "hello!");
        model.addAttribute("data",map);
        return "hello";
    }
}
