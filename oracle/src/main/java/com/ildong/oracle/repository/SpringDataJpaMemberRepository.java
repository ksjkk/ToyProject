package com.ildong.oracle.repository;

import com.ildong.oracle.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,String>, MemberRepository {
}
