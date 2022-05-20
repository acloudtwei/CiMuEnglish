package com.english.cimu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.Cet4Dao;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Cet4;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.model.UserChoose;
import com.english.cimu.service.Cet4Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Cet4)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-11 08:49:50
 */
@Service("cet4Service")
public class Cet4ServiceImpl implements Cet4Service {

    @Resource
    Cet4Dao cet4Dao;

    @Resource
    ReviewwordDao reviewwordDao;

    @Override
    public Cet4 randomone(UserChoose userChoose) {
        QueryWrapper<Cet4> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("limit 1");
        Cet4 cet4s = cet4Dao.selectOne(wrapper);
        Reviewword reviewword = new Reviewword();
        reviewword.setUsername(userChoose.getUsername());
        reviewword.setWord(cet4s.getHeadword());
        reviewword.setWordtype(userChoose.getWordtype());
        reviewword.setSynos(cet4s.getSynos());
        int i = reviewwordDao.insert(reviewword);
        return cet4s;
    }

}

