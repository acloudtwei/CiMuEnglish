package com.english.cimu.service;

import cn.hutool.json.JSONObject;
import com.english.cimu.Vo.UserVo;
import com.english.cimu.entity.User;
import org.springframework.cache.annotation.CacheConfig;

/**
 * (User)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-10 02:57:30
 */

public interface UserService {

    UserVo checkuser(User user);

    Boolean register(User user);

    Boolean emailjudge(String email);

    Boolean emailjudges(String email);

    Boolean usernamejudge(String username);

    Boolean forgetpsw(String email, String changepassword);

    JSONObject getmessage(String username);

}

