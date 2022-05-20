package com.english.cimu.model;

import lombok.Data;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/10/30 13:27
 */
@Data
public class JsonModel {
    private int code;
    private boolean success;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
