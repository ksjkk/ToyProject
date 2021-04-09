package com.ildong.demo3.core.api.emp;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_COP_USER_INFO")
public class Emp {
    @Id
    @Column(length = 10, unique=true)
    private String id;

    @Column(length = 30, nullable = false)
    private String displayName;

    @Column(length = 4, nullable = false)
    private String enterCd;

    @Column(length = 30, nullable = false)
    private String jikchakNm;

    @Column(length = 30, nullable = false)
    private String jikgubNm;

    @Column(length = 30, nullable = false)
    private String jikweeNm;

    @Column(length = 10, nullable = false)
    private String orgCd;

    @Column(length = 50, nullable = false)
    private String orgNm;

    @OneToMany(cascade = CascadeType.REMOVE)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "T_COP_USER_AUTHORITIES",
            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_CODE", referencedColumnName = "AUTHORITY_CODE")})
    private Set<Authority> authorities;

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEnterCd() {
        return enterCd;
    }

    public String getJikchakNm() {
        return jikchakNm;
    }

    public String getJikgubNm() {
        return jikgubNm;
    }

    public String getJikweeNm() {
        return jikweeNm;
    }

    public String getOrgCd() {
        return orgCd;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Emp(String id, String displayName, String enterCd, String jikchakNm, String jikgubNm, String jikweeNm, String orgCd, String orgNm, Set<Authority> authorities) {
        this.id = id;
        this.displayName = displayName;
        this.enterCd = enterCd;
        this.jikchakNm = jikchakNm;
        this.jikgubNm = jikgubNm;
        this.jikweeNm = jikweeNm;
        this.orgCd = orgCd;
        this.orgNm = orgNm;
        this.authorities = authorities;
    }

    public Emp() {
    }
}
