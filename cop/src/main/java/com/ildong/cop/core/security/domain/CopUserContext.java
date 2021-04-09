package com.ildong.cop.core.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class CopUserContext {
    public static String enterCd;
    public static String username;
    public static String password;
    public static String displayName;
    public static String jikchakNm;
    public static String jikgubNm;
    public static String jikweeNm;
    public static String orgCd;
    public static String orgNm;

    public static String getEnterCd() { return enterCd; }

    public static void setEnterCd(String enterCd) { CopUserContext.enterCd = enterCd; }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CopUserContext.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CopUserContext.password = password;
    }

    public static String getDisplayName() {
        return displayName;
    }

    public static void setDisplayName(String displayName) {
        CopUserContext.displayName = displayName;
    }

    public static String getJikchakNm() {
        return jikchakNm;
    }

    public static void setJikchakNm(String jikchakNm) {
        CopUserContext.jikchakNm = jikchakNm;
    }

    public static String getJikgubNm() {
        return jikgubNm;
    }

    public static void setJikgubNm(String jikgubNm) {
        CopUserContext.jikgubNm = jikgubNm;
    }

    public static String getJikweeNm() {
        return jikweeNm;
    }

    public static void setJikweeNm(String jikweeNm) {
        CopUserContext.jikweeNm = jikweeNm;
    }

    public static String getOrgCd() {
        return orgCd;
    }

    public static void setOrgCd(String orgCd) {
        CopUserContext.orgCd = orgCd;
    }

    public static String getOrgNm() {
        return orgNm;
    }

    public static void setOrgNm(String orgNm) {
        CopUserContext.orgNm = orgNm;
    }

    public static Map getInfo(){
        Map map = new HashMap<String,String>();
        map.put("enterCd",getEnterCd());
        map.put("username",getUsername());
        map.put("displayName",getDisplayName());
        map.put("jikchakNm",getJikchakNm());
        map.put("jikgubNm",getJikgubNm());
        map.put("jikweeNm",getJikweeNm());
        map.put("orgCd",getOrgCd());
        map.put("orgNm",getOrgNm());
        return map;
    }
}
