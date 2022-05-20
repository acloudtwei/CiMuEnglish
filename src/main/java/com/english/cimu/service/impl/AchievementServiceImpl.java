package com.english.cimu.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.english.cimu.dao.AchievementDao;
import com.english.cimu.dao.ReviewwordDao;
import com.english.cimu.entity.Achievement;
import com.english.cimu.entity.Reviewword;
import com.english.cimu.service.AchievementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Achievement)表服务实现类
 *
 * @author acloudtwei
 * @since 2021-12-10 16:41:20
 */
@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

    @Resource
    ReviewwordDao reviewwordDao;

    @Resource
    AchievementDao achievementDao;

    private final Map<String, Integer> rankname = new HashMap<String, Integer>() {
        {
            put("cet4", 3008);
            put("cet6", 1376);
            put("chuzhong", 1174);
            put("gaozhong", 2834);
        }
    };

    private final Map<String, String> wordname = new HashMap<String, String>() {
        {
            put("cet4", "四级");
            put("cet6", "六级");
            put("chuzhong", "初中");
            put("gaozhong", "高考");
        }
    };

    @Override
    public JSONObject getrank(String username, String wordtype) {
        QueryWrapper<Reviewword> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username).eq("wordtype", wordtype).eq("learn", 1);
        JSONObject json = new JSONObject();
        int ranknum = reviewwordDao.selectList(wrapper).size();
        json.putOpt("studywords", ranknum);
        json.putOpt("nostudywords", rankname.get(wordtype));
        json.putOpt("wordname", wordname.get(wordtype));
        Achievement achievement = new Achievement();
        achievement.setUsername(username);
        if ("cet4".equals(wordtype)) {
            achievement.setCet4word(ranknum);
            achievement.setCet6word(0);
            achievement.setChuzhong(0);
            achievement.setGaozhong(0);
        } else if ("cet6".equals(wordtype)) {
            achievement.setCet6word(ranknum);
            achievement.setCet4word(0);
            achievement.setChuzhong(0);
            achievement.setGaozhong(0);
        } else if ("chuzhong".equals(wordtype)) {
            achievement.setChuzhong(ranknum);
            achievement.setCet4word(0);
            achievement.setCet6word(0);
            achievement.setGaozhong(0);
        } else {
            achievement.setGaozhong(ranknum);
            achievement.setCet4word(0);
            achievement.setCet6word(0);
            achievement.setChuzhong(0);
        }
        if (ranknum < 10) {
            json.putOpt("rankname", "不堪一击");
        } else if (ranknum > 11 && ranknum < 50) {
            json.putOpt("rankname", "平淡无奇");
        } else if (ranknum > 51 && ranknum < 100) {
            json.putOpt("rankname", "驾轻就熟");
        } else if (ranknum > 101 && ranknum < 200) {
            json.putOpt("rankname", "炉火纯青");
        }
        achievementDao.insert(achievement);
        return json;
    }
}

