package com.english.cimu.Utils;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/31 22:07
 */

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.UserDao;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.entity.User;
import org.springframework.stereotype.Component;
import cn.dev33.satoken.stp.StpInterface;

import javax.annotation.Resource;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Resource
    UserDao userDao;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user-add");
        list.add("user-delete");
        list.add("user-update");
        list.add("user-get");
        list.add("article-get");
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<String> list = new ArrayList<String>();
        wrapper.eq("authority", 1);
        for (User user : userDao.selectList(wrapper)) {
            list.add(user.getUsername());
        }
        if (list.contains((String) loginId)) {
//            list.add("admin");
            list.add("super-admin");
        } else {
            list.add("admin");
        }
        return list;
    }

//    StpUtil.getLoginId();

}
