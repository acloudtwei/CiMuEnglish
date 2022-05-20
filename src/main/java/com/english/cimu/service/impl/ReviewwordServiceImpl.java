package com.english.cimu.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.service.ReviewwordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reviewword)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-11 15:06:20
 */
@Service("reviewwordService")
public class ReviewwordServiceImpl implements ReviewwordService {

    @Resource
    ReviewwordDao reviewwordDao;

    @Override
    public JSONObject getwordmessage(String username, String wordtype) {
        QueryWrapper<Reviewword> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username).eq("wordtype", wordtype).eq("learn", 0)
                .orderByAsc("RAND()").last("limit 1");
        List<Reviewword> reviewword = reviewwordDao.selectList(wrapper);
        JSONObject json = new JSONObject();
        if (reviewword.size() == 0) {
            json.putOpt("word", "");
            json.putOpt("wordexplains", "{'CiMu提示': '你的单词都学完啦!'}");
        } else {
            json.putOpt("word", reviewword.get(0).getWord());
            json.putOpt("wordexplains", reviewword.get(0).getSynos());
        }
        return json;
    }

    @Override
    public Boolean updatelearn(String username, String word) {
        UpdateWrapper<Reviewword> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username).eq("word", word).set("learn", 1);
        reviewwordDao.update(null, updateWrapper);
        return true;
    }


}

