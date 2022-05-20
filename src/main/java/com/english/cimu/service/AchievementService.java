package com.english.cimu.service;

import cn.hutool.json.JSONObject;

/**
 * (Achievement)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-10 16:41:20
 */
public interface AchievementService {

    JSONObject getrank(String username,String keyword);

}

