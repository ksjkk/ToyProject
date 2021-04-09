package com.ildong.oracle.service;

import com.ildong.auth.domain.AdUser;
import com.ildong.auth.infra.AuthService;
import com.ildong.oracle.domain.Member;
import com.ildong.oracle.repository.MemberRepository;
import com.ildong.oracle.repository.SpringDataJpaMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
//    private final MemberRepository memberRepository;
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findByEmpno(String empno){
        return memberRepository.findByEmpno(empno);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public boolean loginAd(String id,String password){
        return new AuthService().adLogin(id,password);
    }
}
