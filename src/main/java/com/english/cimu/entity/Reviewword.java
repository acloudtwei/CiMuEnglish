package com.english.cimu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Reviewword)表实体类
 *
 * @author acloudtwei
 * @since 2021-12-11 15:53:48
 */
@SuppressWarnings("serial")
public class Reviewword {

    private String username;

    private String word;

    private Integer learn;

    private String wordtype;

    private String synos;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getLearn() {
        return learn;
    }

    public void setLearn(Integer learn) {
        this.learn = learn;
    }

    public String getWordtype() {
        return wordtype;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype;
    }

    public String getSynos() {
        return synos;
    }

    public void setSynos(String synos) {
        this.synos = synos;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    protected Serializable pkVal() {
        return this.word;
    }
}

