package com.ildong.demo.domain.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tuser")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GENERATOR")
//    @SequenceGenerator(name="SEQ_GENERATOR",sequenceName = "JPA_TEST_SEQ",allocationSize = 1)
//    private Long id;

    @Id
    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @JsonIgnore
    @Column(name = "activated", length = 1)
    private String activated;

    @Column(columnDefinition = "DATE DEFAULT SYSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date regDate = new Date();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tuser_authority",
            joinColumns = {@JoinColumn(name = "username", referencedColumnName = "username")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}