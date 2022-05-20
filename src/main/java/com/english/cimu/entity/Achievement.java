package com.english.cimu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Achievement)表实体类
 *
 * @author acloudtwei
 * @since 2021-12-11 19:40:04
 */
@SuppressWarnings("serial")
public class Achievement {
    
    private String username;
    
    private Integer cet4word;
    
    private Integer cet6word;
    
    private Integer chuzhong;
    
    private Integer gaozhong;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCet4word() {
        return cet4word;
    }

    public void setCet4word(Integer cet4word) {
        this.cet4word = cet4word;
    }

    public Integer getCet6word() {
        return cet6word;
    }

    public void setCet6word(Integer cet6word) {
        this.cet6word = cet6word;
    }

    public Integer getChuzhong() {
        return chuzhong;
    }

    public void setChuzhong(Integer chuzhong) {
        this.chuzhong = chuzhong;
    }

    public Integer getGaozhong() {
        return gaozhong;
    }

    public void setGaozhong(Integer gaozhong) {
        this.gaozhong = gaozhong;
    }

}

