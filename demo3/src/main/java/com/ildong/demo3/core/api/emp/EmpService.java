package com.ildong.demo3.core.api.emp;

import com.ildong.demo3.core.security.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpService {
    private final EmpRepository empRepository;

    public EmpService(EmpRepository empRepository){
        this.empRepository = empRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Emp> getUserWithAuthorities(String id) {
        return empRepository.findOneWithAuthoritiesById(id);
    }
}
