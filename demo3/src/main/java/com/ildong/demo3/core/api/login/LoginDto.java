package com.ildong.demo3.core.api.login;

public class LoginDto {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginDto(String username, String password){
        this.username = username;
        this.password = password;
    }

    public LoginDto(){}
}
