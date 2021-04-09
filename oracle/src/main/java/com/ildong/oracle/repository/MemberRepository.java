package com.ildong.oracle.repository;

import com.ildong.oracle.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findByEmpno(String empno);
    List<Member> findAll();
}
