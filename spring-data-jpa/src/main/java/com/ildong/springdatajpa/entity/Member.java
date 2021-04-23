package com.ildong.springdatajpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends JpaBaseEntity{

    @Id @GeneratedValue
    private Long id;
    private String username;

    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
