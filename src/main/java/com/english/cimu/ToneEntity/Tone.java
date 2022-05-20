package com.english.cimu.ToneEntity;

import lombok.Data;


@Data
public class Tone {
    private Integer  Trank;
    private String eg;
    private String optionA;
    private String optionB;
    private String optionC;

    public int getTrank() {
        return Trank;
    }

    public void setTrank(int trank) {
        Trank = trank;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }



    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    private String optionD;

    public void setTrank(Integer trank) {
        Trank = trank;
    }


    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    private String rights;
    private String analysis;



}