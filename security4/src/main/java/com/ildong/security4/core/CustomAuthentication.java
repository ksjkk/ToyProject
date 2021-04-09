package com.ildong.security4.core;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication implements GrantedAuthority {
    private final String PREFIX = "ROLE_";
    private String authority;

    @Override
    public String getAuthority() {
        return PREFIX + authority;
    }

    public CustomAuthentication(String authority) {
        this.authority = authority;
    }
}
