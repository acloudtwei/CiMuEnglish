package com.english.cimu.Utils;


import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/28 22:46
 */
public class TweiResult extends LinkedHashMap<String, Object> implements Serializable{
    private static final long serialVersionUID = 1L;

    public TweiResult(int code, String msg,long count, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setCount(count);
    }

    public Integer getCode() {
        return (Integer)this.get("code");
    }


    public String getMsg() {
        return (String)this.get("msg");
    }


    public Object getData() {
        return this.get("data");
    }

    public int getCount() {
        return (int)this.get("count");
    }

    public TweiResult setCode(int code) {
        this.put("code", code);
        return this;
    }


    public TweiResult setMsg(String msg) {
        this.put("msg", msg);
        return this;
    }


    public TweiResult setData(Object data) {
        this.put("data", data);
        return this;
    }

    public TweiResult setCount(long count) {
        this.put("count", count);
        return this;
    }

    public static TweiResult ok(long count,Object data) {
        return new TweiResult(0, "ok",count, data);
    }

    public static TweiResult error() {
        return new TweiResult(500, "error", 0,(Object)null);
    }

    public static TweiResult error(String msg) {
        return new TweiResult(500, msg,0, (Object)null);
    }

    public static TweiResult get(int code, String msg, long count,Object data) {
        return new TweiResult(code, msg, count,data);
    }

    @Override
    public String toString() {
        return "{\"code\": " + this.getCode() + ", \"msg\": \"" + this.getMsg() + "," +
                "\"count\": " + this.getCount() + "\"," +"\"data\": \"" + this.getData() + "\"}";
    }
}
