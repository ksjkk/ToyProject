package com.ildong.demo3.core.api.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COP_AUTHORITIES")
public class Authority {
    @Id
    @Column(name = "AUTHORITY_CODE", length = 20)
    private String authorityCode;

    @Column(name = "AUTHORITY_NAME", length = 30)
    private String authorityName;

    public String getAuthorityCode() {
        return authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public Authority(String authorityCode, String authorityName) {
        this.authorityCode = authorityCode;
        this.authorityName = authorityName;
    }

    public Authority() {
    }
}
