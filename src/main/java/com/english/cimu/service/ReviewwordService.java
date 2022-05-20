package com.english.cimu.service;

import cn.hutool.json.JSONObject;

/**
 * (Reviewword)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-11 15:06:20
 */
public interface ReviewwordService {
    JSONObject getwordmessage(String username, String wordtype);

    Boolean updatelearn(String username,String word);

}

