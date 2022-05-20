package com.english.cimu.Encrypt;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/10/28 17:11
 */

public class Md5Encrypt {
    public static String EncoderByMd5(String str, String key) {
        String newStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
            str = newStr + key;
            newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }
}
