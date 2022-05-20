package com.english.cimu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Cet6)表实体类
 *
 * @author acloudtwei
 * @since 2021-12-11 08:50:06
 */
@SuppressWarnings("serial")
public class Cet6  {
    
    private Integer wordrank;
    
    private String headword;
    
    private String sentences;
    
    private String phrases;
    
    private String usphone;
    
    private String usspeech;
    
    private String ukphone;
    
    private String ukspeech;
    
    private String synos;


    public Integer getWordrank() {
        return wordrank;
    }

    public void setWordrank(Integer wordrank) {
        this.wordrank = wordrank;
    }

    public String getHeadword() {
        return headword;
    }

    public void setHeadword(String headword) {
        this.headword = headword;
    }

    public String getSentences() {
        return sentences;
    }

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    public String getPhrases() {
        return phrases;
    }

    public void setPhrases(String phrases) {
        this.phrases = phrases;
    }

    public String getUsphone() {
        return usphone;
    }

    public void setUsphone(String usphone) {
        this.usphone = usphone;
    }

    public String getUsspeech() {
        return usspeech;
    }

    public void setUsspeech(String usspeech) {
        this.usspeech = usspeech;
    }

    public String getUkphone() {
        return ukphone;
    }

    public void setUkphone(String ukphone) {
        this.ukphone = ukphone;
    }

    public String getUkspeech() {
        return ukspeech;
    }

    public void setUkspeech(String ukspeech) {
        this.ukspeech = ukspeech;
    }

    public String getSynos() {
        return synos;
    }

    public void setSynos(String synos) {
        this.synos = synos;
    }

}

