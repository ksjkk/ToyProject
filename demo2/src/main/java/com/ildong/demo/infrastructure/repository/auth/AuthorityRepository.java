package com.ildong.demo.infrastructure.repository.auth;

import com.ildong.demo.domain.auth.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
