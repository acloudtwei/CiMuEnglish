package com.english.cimu.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.WordcollectionDao;
import com.english.cimu.dao.WordsDao;
import com.english.cimu.entity.Wordcollection;
import com.english.cimu.entity.Words;
import com.english.cimu.service.WordcollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Wordcollection)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-10 10:46:21
 */
@Service("wordcollectionService")
public class WordcollectionServiceImpl implements WordcollectionService {

    @Resource
    WordcollectionDao wordcollectionDao;

    @Resource
    WordsDao wordsDao;

    @Override
    public Boolean addcollection(Wordcollection wordcollection) {
        return wordcollectionDao.insert(wordcollection) > 0;
    }

    @Override
    public Boolean judgeword(String word) {
        QueryWrapper<Wordcollection> wrapper = new QueryWrapper<>();
        wrapper.eq("word", word);
        List<Wordcollection> users = wordcollectionDao.selectList(wrapper);
        return users.isEmpty();
//        1 就是单词不存在
    }

    @Override
    public Boolean deletecollection(Wordcollection wordcollection) {
        QueryWrapper<Wordcollection> wrapper = new QueryWrapper<>();
        wrapper.eq("word", wordcollection.getWord())
                .eq("username", wordcollection.getUsername());
        return wordcollectionDao.delete(wrapper) > 0;
    }

    @Override
    public List<String> getallword(String username) {
        QueryWrapper<Wordcollection> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<Wordcollection> allword = wordcollectionDao.selectList(wrapper);
        List<String> list = new ArrayList<>();
        for (Wordcollection c : allword) {
            list.add(c.getWord());
        }
        return list;
    }

    @Override
    public List<JSONObject> getwordmessage(String username) {
        QueryWrapper<Wordcollection> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<Wordcollection> allword = wordcollectionDao.selectList(wrapper);
        List<JSONObject> list = new ArrayList<>();
        for (Wordcollection c : allword) {
            JSONObject json = new JSONObject();
            QueryWrapper<Words> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("headWord", c.getWord()).last("limit 1");
            Words worddata = wordsDao.selectList(wrapper1).get(0);
            json.putOpt("word", worddata.getHeadword());
            json.putOpt("wordexplain", worddata.getSynos());
            list.add(json);
        }
        return list;
    }
}