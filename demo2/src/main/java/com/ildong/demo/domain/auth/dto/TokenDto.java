package com.ildong.demo.domain.auth.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String token;

    public String getToken() {
        return token;
    }
}
