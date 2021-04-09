package com.ildong.demo3.core.api.emp;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpRepository extends JpaRepository<Emp,String> {
    @EntityGraph(attributePaths = "authorities")
    Optional<Emp> findOneWithAuthoritiesById(String Id);
}
