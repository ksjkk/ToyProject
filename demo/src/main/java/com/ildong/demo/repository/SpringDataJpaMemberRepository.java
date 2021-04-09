package com.ildong.demo.repository;

import com.ildong.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    // -> JpaRepository : Interface에 대한 구현체를 생성 그리고 스프링 Bean에 등록해놓음
//    @Override
//    Member save(Member member);
//
//    @Override
//    Optional<Member> findByName(String name);
//
//    @Override
//    Optional<Member> findById(Long id);
//
//    @Override
//    List<Member> findAll();
}
