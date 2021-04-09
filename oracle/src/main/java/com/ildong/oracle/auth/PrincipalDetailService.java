package com.ildong.oracle.auth;

import com.ildong.oracle.domain.Member;
import com.ildong.oracle.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrincipalDetailService implements UserDetailsService {

    private MemberRepository memberRepository;

    public PrincipalDetailService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 스프링이 로그인 요청을 가로챌 때 username, password 변수 2개를 가로챔
     * password 부분처리는 알아서함
     * username이 있는지만 확인해주면됨
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member principal = memberRepository.findByEmpno(username).orElseThrow(() -> {
            return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : "+username);
        });
        return new PrincipalDetail(principal);  // 시큐리티 세션에 유저정보가 저장이 됨
    }
}
