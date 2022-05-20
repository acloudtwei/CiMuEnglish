package com.english.cimu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.GaozhongDao;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Gaozhong;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.model.UserChoose;
import com.english.cimu.service.GaozhongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Gaozhong)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-11 08:50:46
 */
@Service("gaozhongService")
public class GaozhongServiceImpl implements GaozhongService {

    @Resource
    GaozhongDao gaozhongDao;

    @Resource
    ReviewwordDao reviewwordDao;

    @Override
    public Gaozhong randomone(UserChoose userChoose) {
        QueryWrapper<Gaozhong> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("limit 1");
        Gaozhong gaozhongs = gaozhongDao.selectList(wrapper).get(0);
        Reviewword reviewword = new Reviewword();
        reviewword.setUsername(userChoose.getUsername());
        reviewword.setWord(gaozhongs.getHeadword());
        reviewword.setWordtype(userChoose.getWordtype());
        reviewword.setSynos(gaozhongs.getSynos());
        int i = reviewwordDao.insert(reviewword);
        return gaozhongs;
    }
}

