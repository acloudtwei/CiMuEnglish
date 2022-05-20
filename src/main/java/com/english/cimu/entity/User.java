package com.english.cimu.entity;

import java.io.Serializable;


/**
 * (User)表实体类
 *
 * @author acloudtwei
 * @since 2022-01-01 02:40:31
 */
@SuppressWarnings("serial")
public class User  {
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Integer authority;
    
    private String remarks;
    
    private String registertime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
        protected Serializable pkVal() {
        return this.username;
    }
    }

