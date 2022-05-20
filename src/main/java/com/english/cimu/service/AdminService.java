package com.english.cimu.service;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.entity.Gaozhong;
import com.english.cimu.entity.User;


/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/31 15:44
 */
public interface AdminService {

    TweiResult getusers(Page<User> page);

    SaResult getsumdata();

    SaResult topassword(String password);

    SaResult toauthority(User user);

    SaResult tomodify(String username, String item);

    SaResult toalldelete(String username);

    SaResult toadduser(User user);

    SaResult updatemessage(String username, User user);

    SaResult updatepassword(String username, String password);

    SaResult judgeuser();
}
