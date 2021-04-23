package com.ildong.springdatajpa.repository;

import com.ildong.springdatajpa.entity.Member;
import com.ildong.springdatajpa.entity.UsernameOnlyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Page<Member> findByAgeGreaterThan(int age, Pageable pageable);
    Page<Member> findAll(Pageable pageable);

    List<UsernameOnlyDto> findProjectionsByUsername(@Param("username") String username);
}
