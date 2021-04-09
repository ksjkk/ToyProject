package com.ildong.oracle.auth;

import com.ildong.oracle.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료되면 UserDetails 타입의 오브젝트를
 * 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
 * */
public class PrincipalDetail implements UserDetails {
    private Member user;

    public PrincipalDetail(Member user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmpno();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 계정의 권한을 리턴함
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_USER";
//            }
//        });
        collectors.add( () -> { return "ROLE_USER"; } );
        return collectors;
    }
}
