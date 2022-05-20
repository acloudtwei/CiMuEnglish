package com.english.cimu.service.impl;

import com.english.cimu.Vo.UserVo;
import com.english.cimu.entity.User;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.english.cimu.Encrypt.Md5Encrypt;
import com.english.cimu.dao.UserDao;
import com.english.cimu.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * (User)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-10 02:57:30
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override

    public UserVo checkuser(User user) {
        QueryWrapper<User> wrapperbyname = new QueryWrapper<>();
        wrapperbyname.eq("username", user.getUsername());

        QueryWrapper<User> wrapperbyemail = new QueryWrapper<>();
        wrapperbyemail.eq("email", user.getUsername());

        UserVo userVo = new UserVo();
        List<User> result = userDao.selectList(wrapperbyname);
        if (result.size() == 0) {
            result = userDao.selectList(wrapperbyemail);
            if (result.size() == 0) {
                userVo.setMessage("alert('用户名或邮箱不正确!')");
                return userVo;
            }
        }
        if (Md5Encrypt.EncoderByMd5(user.getPassword(), "acloudtwei").equals(result.get(0).getPassword())) {
            userVo.setUsername(result.get(0).getUsername());
            userVo.setEmail(result.get(0).getEmail());
            userVo.setRegistertime(result.get(0).getRegistertime());
            userVo.setMessage("success");
        } else {
            userVo.setMessage("alert('密码错误!')");
        }
        return userVo;

    }

    @Override
    public Boolean register(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean emailjudge(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        List<User> users = userDao.selectList(wrapper);
        return users.isEmpty();
    }

    @Override
    public Boolean emailjudges(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        List<User> users = userDao.selectList(wrapper);
        return !users.isEmpty();
    }

    @Override
    public Boolean usernamejudge(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> users = userDao.selectList(wrapper);
//        有就返回true
        return !users.isEmpty();
    }

    @Override
    public Boolean forgetpsw(String email, String changepassword) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.set("password", Md5Encrypt.EncoderByMd5(changepassword, "acloudtwei")).eq("email", email);
        return userDao.update(null, wrapper) > 0;
    }

    @Override
    public JSONObject getmessage(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userDao.selectOne(wrapper);
        JSONObject json = new JSONObject();
        json.putOpt("username", user.getUsername());
        json.putOpt("email", user.getEmail());
        json.putOpt("qq", user.getEmail().split("@")[0]);
        return json;
    }
}

