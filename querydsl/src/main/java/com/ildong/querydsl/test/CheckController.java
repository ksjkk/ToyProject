package com.ildong.querydsl.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
    @GetMapping("/check")
    public String queryDslSettingCheck(){
        return "set querydsl checked";
    }
}
