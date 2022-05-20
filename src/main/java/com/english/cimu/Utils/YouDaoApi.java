package com.english.cimu.Utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.english.cimu.model.QueryWords;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/7 11:19
 */
@Component("YouDaoApi")
public class YouDaoApi {

    private static final Log log = LogFactory.get();

    private static final String YOUDAO_URL = "https://openapi.youdao.com/api";

    private static final String APP_KEY = "70cdfada8ffac5f2";

    private static final String APP_SECRET = "8b31DVPQJMgyHnwMIWWIiN41OEr7wFff";


    /**
     * 公共请求接口方法
     */
    private String getrequest(String word) {
        Map<String, Object> params = new HashMap<String, Object>();
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("from", "auto");
        params.put("to", "auto");
        params.put("signType", "v3");
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        params.put("curtime", curtime);
        String signStr = APP_KEY + truncate(word) + salt + curtime + APP_SECRET;
        String sign = getDigest(signStr);
        params.put("appKey", APP_KEY);
        params.put("q", word);
        params.put("salt", salt);
        params.put("sign", sign);
        params.put("vocabId", "您的用户词表ID");
        log.info("请求成功！", Level.INFO);
        return HttpUtil.post(YOUDAO_URL, params);
    }

    /**
     * 查找单词的方法
     */
    public QueryWords queryword(String word) {
        QueryWords queryWords = new QueryWords();
        String responsedata = getrequest(word);
        JSONObject jsonObject = JSONUtil.parseObj(responsedata);
        queryWords.setQuery(jsonObject.getStr("query"));
        JSONObject jsonObject1 = JSONUtil.parseObj(jsonObject.getStr("basic"));
        queryWords.setUsphonetic(jsonObject1.getStr("us-phonetic"));
        queryWords.setUkphonetic(jsonObject1.getStr("uk-phonetic"));
        queryWords.setUsspeech(jsonObject1.getStr("us-speech"));
        queryWords.setUkspeech(jsonObject1.getStr("uk-speech"));
        JSONArray array = JSONUtil.parseArray(jsonObject1.getStr("explains"));
        List<String> list = new ArrayList<>();
        for (Object obj : array) {
            list.add((String) obj);
        }
        queryWords.setExplains(list);
        log.info("返回查询单词：" + word + "的bean", Level.INFO);
        log.info(responsedata, Level.INFO);
        return queryWords;
    }

    /**
     * 翻译的方法    */
    public String querytranslate(String word) {
        log.info("返回翻译语句：" + word + "的翻译结果", Level.INFO);
        if(word != null && word.length() > 0)
        {
            return  (String)JSONUtil.parseArray(JSONUtil.parseObj(getrequest(word)).getStr("translation")).get(0);
        }
        return "啥也没输入~";
    }

    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }


    /**
     * input是要翻译的数据
     * ，input的计算方式为：input=q前10个字符 + q长度 + q后10个字符（当q长度大于20）或 input=q字符串
     */
    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }
}