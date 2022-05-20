package com.english.cimu.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Encrypt.Md5Encrypt;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.Vo.SumVo;
import com.english.cimu.Vo.UserVo;
import com.english.cimu.dao.ToneDao;
import com.english.cimu.dao.TtwoDao;
import com.english.cimu.dao.UserDao;
import com.english.cimu.dao.WordsDao;
import com.english.cimu.entity.Cet4;
import com.english.cimu.entity.Cet6;
import com.english.cimu.entity.Gaozhong;
import com.english.cimu.entity.User;
import com.english.cimu.mapper.PthArticleMapper;
import com.english.cimu.mapper.PthDataMapper;
import com.english.cimu.mapper.PthWordMapper;
import com.english.cimu.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/31 15:44
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    UserDao userDao;

    @Resource
    WordsDao wordsDao;

    @Resource
    ToneDao toneDao;

    @Resource
    TtwoDao ttwoDao;

    @Resource
    PthArticleMapper pthArticleMapper;

    @Resource
    PthWordMapper pthWordMapper;

    @Resource
    PthDataMapper pthDataMapper;

    @Override
    public TweiResult getusers(Page<User> page) {
        //		调用Mapper接口返回一个page对象
        Page<User> jobInfoPage = userDao.selectPage(page, null);
        //page对象转list对象
        List<User> records = jobInfoPage.getRecords();
        return TweiResult.ok(userDao.selectCount(null), records);

    }

    @Override
    public SaResult getsumdata() {
        SumVo sumVo1 = new SumVo();
        sumVo1.setName("用户总数");
        sumVo1.setValue(userDao.selectCount(null));

        SumVo sumVo2 = new SumVo();
        sumVo2.setName("单词总数");
        sumVo2.setValue(wordsDao.selectCount(null));

        SumVo sumVo3 = new SumVo();
        sumVo3.setName("题库总数");
        sumVo3.setValue(toneDao.selectCount(null) + ttwoDao.selectCount(null));

        SumVo sumVo4 = new SumVo();
        sumVo4.setName("资料总数");
        sumVo4.setValue(pthArticleMapper.selectCount(null) + pthWordMapper.selectCount(null) + pthDataMapper.selectCount(null));

        List<SumVo> list = new ArrayList<>();
        list.add(sumVo1);
        list.add(sumVo2);
        list.add(sumVo3);
        list.add(sumVo4);

        return SaResult.data(list);
    }

    @Override
    public SaResult topassword(String password) {
        return SaResult.ok(Md5Encrypt.EncoderByMd5(password, "acloudtwei"));
    }

    @Override
    public SaResult toauthority(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", user.getUsername());
        if (userDao.update(user, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    @Override
    public SaResult tomodify(String username, String item) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = new User();
        updateWrapper.eq("username", username);
        user.setRemarks(item);
        if (userDao.update(user, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    @Override
    public SaResult toalldelete(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Collection<String> truusername = Arrays.asList(username.split(","));
        boolean userjudge = false;
        if (truusername.size() == 0) {
            return SaResult.error("请选择要删除的用户！");
        }
        if (truusername.size() == 1) {
            wrapper.eq("username", username.split(",")[0]);
            if (userDao.delete(wrapper) > 0) {
                return SaResult.ok(username.split(",")[0] + "已删除！");
            }
            return SaResult.error(username.split(",")[0] + "用户不存在！！");
        } else {
            wrapper.in("username", truusername);
            if (userDao.delete(wrapper) > 0) {
                userjudge = true;
            }
        }
        if (userjudge) {
            return SaResult.ok("所选用户删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult toadduser(User user) {
        if (userDao.insert(user) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult updatemessage(String username, User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username);
        UserVo userVo = new UserVo();
        if (userDao.update(user, updateWrapper) > 0) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            userVo.setUsername(userDao.selectOne(queryWrapper).getUsername());
            userVo.setEmail(userDao.selectOne(queryWrapper).getEmail());
            userVo.setRegistertime(userDao.selectOne(queryWrapper).getRegistertime());
            userVo.setMessage("修改成功！");
            return SaResult.data(userVo);
        }
        return SaResult.get(500, "null", "修改失败！");
    }

    @Override
    public SaResult updatepassword(String username, String password) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username);
        User user = new User();
        user.setPassword(Md5Encrypt.EncoderByMd5(password, "acloudtwei"));
        if (userDao.update(user, updateWrapper) > 0) {
            StpUtil.logout();
            return SaResult.ok("修改成功");
        }
        return SaResult.ok("修改失败！");
    }

    @Override
    public SaResult judgeuser() {
        if (!StpUtil.hasRole(StpUtil.getLoginIdDefaultNull(), "super-admin")) {
            StpUtil.kickout(StpUtil.getLoginId());
            return SaResult.ok("location.href=('/home')");
        }
        return null;
    }
}
