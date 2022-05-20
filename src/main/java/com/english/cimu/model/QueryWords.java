package com.english.cimu.model;

import lombok.Data;

import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/6 20:51
 */
@Data
public class QueryWords {
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUsphonetic() {
        return usphonetic;
    }

    public void setUsphonetic(String usphonetic) {
        this.usphonetic = usphonetic;
    }

    public String getUkphonetic() {
        return ukphonetic;
    }

    public void setUkphonetic(String ukphonetic) {
        this.ukphonetic = ukphonetic;
    }

    public String getUsspeech() {
        return usspeech;
    }

    public void setUsspeech(String usspeech) {
        this.usspeech = usspeech;
    }

    public String getUkspeech() {
        return ukspeech;
    }

    public void setUkspeech(String ukspeech) {
        this.ukspeech = ukspeech;
    }

    public List<String> getExplains() {
        return explains;
    }

    public void setExplains(List<String> explains) {
        this.explains = explains;
    }

    private String query;

    private String usphonetic;

    private String ukphonetic;

    private String usspeech;

    private String ukspeech;

    private List<String> explains;

}
