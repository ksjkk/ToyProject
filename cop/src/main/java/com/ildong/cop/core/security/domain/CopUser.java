package com.ildong.cop.core.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "T_COP_USER_INFO")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopUser implements UserDetails {

    @Column(length = 10, nullable = false)
    private String enterCd;

    @Id
    @Column(length = 10, nullable = false)
    private String username;

    @Transient
    private String password;

    @Column(length = 30, nullable = false)
    private String displayName;

    @Column(length = 30, nullable = false)
    private String jikchakNm;

    @Column(length = 30, nullable = false)
    private String jikgubNm;

    @Column(length = 30, nullable = false)
    private String jikweeNm;

    @Column(length = 10, nullable = false)
    private String orgCd;

    @Column(length = 60, nullable = false)
    private String orgNm;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "T_COP_USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "username", referencedColumnName = "username")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_CODE", referencedColumnName = "AUTHORITY_CODE")}
    )
    private Set<CopAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() { return username; }

    public String getEnterCd() { return enterCd; }
    public String getDisplayName() { return displayName; }
    public String getJikchakNm() { return jikchakNm; }
    public String getJikgubNm() { return jikgubNm; }
    public String getJikweeNm() { return jikweeNm; }
    public String getOrgCd() { return orgCd; }
    public String getOrgNm() { return orgNm; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
