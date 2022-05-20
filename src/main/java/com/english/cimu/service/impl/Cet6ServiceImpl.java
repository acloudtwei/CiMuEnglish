package com.english.cimu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.english.cimu.dao.Cet6Dao;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Cet6;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.model.UserChoose;
import com.english.cimu.service.Cet6Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Cet6)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-11 08:50:06
 */
@Service("cet6Service")
public class Cet6ServiceImpl implements Cet6Service {

    @Resource
    Cet6Dao cet6Dao;

    @Resource
    ReviewwordDao reviewwordDao;

    @Override
    public Cet6 randomone(UserChoose userChoose) {
        QueryWrapper<Cet6> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("limit 1");
        Cet6 cet6s = cet6Dao.selectOne(wrapper);
        Reviewword reviewword = new Reviewword();
        reviewword.setUsername(userChoose.getUsername());
        reviewword.setWord(cet6s.getHeadword());
        reviewword.setWordtype(userChoose.getWordtype());
        reviewword.setSynos(cet6s.getSynos());
        int i = reviewwordDao.insert(reviewword);
        return cet6s;
    }
}

