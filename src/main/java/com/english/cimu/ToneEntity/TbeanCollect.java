package com.english.cimu.ToneEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TbeanCollect {

    private String username;
    private Integer Trank;
    private String eg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTrank() {
        return Trank;
    }

    public void setTrank(Integer trank) {
        Trank = trank;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public String getCright() {
        return Cright;
    }

    public void setCright(String cright) {
        Cright = cright;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    private String Cright;
    private String analysis;

}
