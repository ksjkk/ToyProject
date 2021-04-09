package com.ildong.cop.core.security.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COP_AUTHORITY")
@AllArgsConstructor
@NoArgsConstructor
public class CopAuthority implements GrantedAuthority {
    @Id
    @Column(name = "AUTHORITY_CODE", length = 15)
    private String authorityCode;

    @Column(name = "AUTHORITY_NAME", length = 30)
    private String authorityName;

    @Override
    public String getAuthority() {
        return authorityCode;
    }
}
