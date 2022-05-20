package com.english.cimu.model;

import lombok.Data;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/11 15:13
 */
@Data
public class UserChoose {
    private String username;
    private String wordtype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWordtype() {
        return wordtype;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype;
    }
}
