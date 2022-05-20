package com.english.cimu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.ChuzhongDao;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Chuzhong;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.model.UserChoose;
import com.english.cimu.service.ChuzhongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Chuzhong)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-07 17:23:33
 */
@Service("chuzhongService")
public class ChuzhongServiceImpl implements ChuzhongService {
    @Resource
    ChuzhongDao chuzhongDao;

    @Resource
    ReviewwordDao reviewwordDao;

    @Override
    public Chuzhong randomone(UserChoose userChoose) {
        QueryWrapper<Chuzhong> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("limit 1");
        Chuzhong chuzhongs = chuzhongDao.selectList(wrapper).get(0);
        Reviewword reviewword = new Reviewword();
        reviewword.setUsername(userChoose.getUsername());
        reviewword.setWord(chuzhongs.getHeadword());
        reviewword.setWordtype(userChoose.getWordtype());
        reviewword.setSynos(chuzhongs.getSynos());
        int i = reviewwordDao.insert(reviewword);
        return chuzhongs;
    }

    //    https://blog.csdn.net/xzys430/article/details/109215665/

//    https://www.cnblogs.com/yuyueq/p/14639016.html

//    SELECT * FROM cet4 ORDER BY RAND() LIMIT 5


}

