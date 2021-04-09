package com.ildong.cop.core.security.application;

import com.ildong.cop.core.security.domain.CopUser;
import com.ildong.cop.core.security.domain.CopUserContext;
import com.ildong.cop.core.security.infrastructure.CopUserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private CopUserRepository copUserRepository;
    public LoginService(CopUserRepository copUserRepository) {
        this.copUserRepository = copUserRepository;
    }

    public String userContextUpdate(String username){
        try {
            CopUser user = copUserRepository.findOneWithAuthoritiesByUsername(username).get();
            CopUserContext.setEnterCd(user.getEnterCd());
            CopUserContext.setUsername(user.getUsername());
            CopUserContext.setDisplayName(user.getDisplayName());
            CopUserContext.setJikchakNm(user.getJikchakNm());
            CopUserContext.setJikgubNm(user.getJikgubNm());
            CopUserContext.setJikweeNm(user.getJikweeNm());
            CopUserContext.setOrgCd(user.getOrgCd());
            CopUserContext.setOrgNm(user.getOrgNm());
        }
        catch (Exception e){
            // error 화면으로 바뀌어야함
            return "redirect:/api/login-fail";
        }
        return "fragments/view/index";
    }
}
