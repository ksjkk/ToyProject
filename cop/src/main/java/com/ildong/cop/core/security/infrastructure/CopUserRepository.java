package com.ildong.cop.core.security.infrastructure;

import com.ildong.cop.core.security.domain.CopUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CopUserRepository extends JpaRepository<CopUser, String> {
    @EntityGraph(attributePaths = "authorities")
    Optional<CopUser> findOneWithAuthoritiesByUsername(String username);
}
