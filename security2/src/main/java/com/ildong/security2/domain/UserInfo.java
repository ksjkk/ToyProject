package com.ildong.security2.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@SequenceGenerator(
        name = "JPA_TEST_SEQ_GEN",
        sequenceName = "JPA_TEST_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class UserInfo implements UserDetails {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "JPA_TEST_SEQ_GEN")
    private Long code;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "auth")
    private String auth;

    @Builder
    public UserInfo(String email, String password, String auth) {
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    //@Builder
    public UserInfo(Long code, String email, String password, String auth) {
        this.code = code;
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split("\\|")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    // 사용자의 id를 반환 (unique한 값)
    @Override
    public String getUsername() {
        return email;
    }

    // 사용자의 password를 반환
    @Override
    public String getPassword() {
        return password;
    }

    // 계정 만료 안됐나
    @Override
    public boolean isAccountNonExpired(){ return true; }

    // 계정 안잠겼나
    @Override
    public boolean isAccountNonLocked(){ return true; }

    // 패스워드의 만료 안되었나
    @Override
    public boolean isCredentialsNonExpired(){ return true; }

    // 계정 사용가능 한가
    @Override
    public boolean isEnabled() { return true; }
}