package com.english.cimu.entity;

import java.io.Serializable;


/**
 * (Ttwo)表实体类
 *
 * @author acloudtwei
 * @since 2021-12-31 01:58:58
 */
@SuppressWarnings("serial")
public class Ttwo  {
    
    private Integer trank;
    
    private String eg;
    
    private String optiona;
    
    private String optionb;
    
    private String optionc;
    
    private String optiond;
    
    private String analysis;
    
    private String rights;


    public Integer getTrank() {
        return trank;
    }

    public void setTrank(Integer trank) {
        this.trank = trank;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
        protected Serializable pkVal() {
        return this.trank;
    }
    }

