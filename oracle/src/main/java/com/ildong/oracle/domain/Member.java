package com.ildong.oracle.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private String empno;
    private String empnm;
    private String password;

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpnm() {
        return empnm;
    }

    public void setEmpnm(String empnm) {
        this.empnm = empnm;
    }
}
