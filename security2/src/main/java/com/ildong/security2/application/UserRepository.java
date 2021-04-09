package com.ildong.security2.application;

import com.ildong.security2.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByEmail(String email);

    List<UserInfo> findAllByOrderByCodeAsc();
}
