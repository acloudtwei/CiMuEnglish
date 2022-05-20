package com.english.cimu.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.dao.*;
import com.english.cimu.entity.*;
import com.english.cimu.service.WordsService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/29 1:50
 */
@Service
public class WordsServiceImpl implements WordsService {


    @Resource
    Cet4Dao cet4Dao;

    @Resource
    Cet6Dao cet6Dao;

    @Resource
    ChuzhongDao chuzhongDao;

    @Resource
    GaozhongDao gaozhongDao;


    /**
     * 分页查询,yyds
     */

    private boolean judgemethod(String str) {
        return str != null && str.length() != 0;
    }

    private final Map<String, Object> Dao = new HashMap<String, Object>() {
        {
//            put("words", wordsDao);
            put("cet4", cet4Dao);
            put("cet6", cet6Dao);
            put("chuzhong", chuzhongDao);
            put("gaozhong", gaozhongDao);
        }
    };

    @Override
    public TweiResult getcet4words(Page<Cet4> page, String word) {
        //		调用Mapper接口返回一个page对象
        Page<Cet4> jobInfoPage = cet4Dao.selectPage(page, new QueryWrapper<Cet4>().orderByAsc("wordRank"));
        //page对象转list对象
        List<Cet4> records = jobInfoPage.getRecords();

        QueryWrapper<Cet4> wrapper = new QueryWrapper<>();
        wrapper.eq("headWord", word).last("limit 1");
        List<Cet4> words = cet4Dao.selectList(wrapper);

        if (judgemethod(word)) {
            if (words.size() > 0) {
                return TweiResult.ok(1, words);
            } else {
                return TweiResult.get(200, "输入的单词不再数据库中！", 0, "null");
            }
        }
        return TweiResult.ok(cet4Dao.selectCount(null), records);

    }

    @Override
    public TweiResult getcet6words(Page<Cet6> page, String word) {
        //		调用Mapper接口返回一个page对象
        Page<Cet6> jobInfoPage = cet6Dao.selectPage(page, new QueryWrapper<Cet6>().orderByAsc("wordRank"));
        //page对象转list对象
        List<Cet6> records = jobInfoPage.getRecords();

        QueryWrapper<Cet6> wrapper = new QueryWrapper<>();
        wrapper.eq("headWord", word).last("limit 1");
        List<Cet6> words = cet6Dao.selectList(wrapper);

        if (judgemethod(word)) {
            if (words.size() > 0) {
                return TweiResult.ok(1, words);
            } else {
                return TweiResult.get(200, "输入的单词不再数据库中！", 0, "null");
            }
        }
        return TweiResult.ok(cet6Dao.selectCount(null), records);

    }

    @Override
    public TweiResult getchuzhongwords(Page<Chuzhong> page, String word) {
        //		调用Mapper接口返回一个page对象
        Page<Chuzhong> jobInfoPage = chuzhongDao.selectPage(page, new QueryWrapper<Chuzhong>().orderByAsc("wordRank"));
        //page对象转list对象
        List<Chuzhong> records = jobInfoPage.getRecords();

        QueryWrapper<Chuzhong> wrapper = new QueryWrapper<>();
        wrapper.eq("headWord", word).last("limit 1");
        List<Chuzhong> words = chuzhongDao.selectList(wrapper);

        if (judgemethod(word)) {
            if (words.size() > 0) {
                return TweiResult.ok(1, words);
            } else {
                return TweiResult.get(200, "输入的单词不再数据库中！", 0, "null");
            }
        }
        return TweiResult.ok(chuzhongDao.selectCount(null), records);
    }

    @Override
    public TweiResult getgaozhongwords(Page<Gaozhong> page, String word) {
        //		调用Mapper接口返回一个page对象
        Page<Gaozhong> jobInfoPage = gaozhongDao.selectPage(page, new QueryWrapper<Gaozhong>().orderByAsc("wordRank"));
        //page对象转list对象
        List<Gaozhong> records = jobInfoPage.getRecords();

        QueryWrapper<Gaozhong> wrapper = new QueryWrapper<>();
        wrapper.eq("headWord", word).last("limit 1");
        List<Gaozhong> words = gaozhongDao.selectList(wrapper);

        if (judgemethod(word)) {
            if (words.size() > 0) {
                return TweiResult.ok(1, words);
            } else {
                return TweiResult.get(200, "输入的单词不再数据库中！", 0, "null");
            }
        }
        return TweiResult.ok(gaozhongDao.selectCount(null), records);
    }

//    Cet4
//    删除操作

    @Override
    public SaResult cet4alldelete(String words) {
        QueryWrapper<Cet4> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(words.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的单词！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("headWord", words.split(",")[0]);
            if (cet4Dao.delete(wrapper) > 0) {
                return SaResult.ok(words.split(",")[0] + "已删除！");
            }
            return SaResult.error(words.split(",")[0] + "单词不存在！！");
        } else {
            wrapper.in("headWord", trueword);
            if (cet4Dao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选单词删除成功！");
        }
        return SaResult.error();
    }

    //    添加单词操作
    @Override
    public SaResult cet4addword(Cet4 cet4) {
        if (cet4Dao.insert(cet4) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    //    更新单词
    @Override
    public SaResult cet4update(Cet4 cet4) {
        //把名字为rhb的用户年龄更新为18，其他属性不变
        UpdateWrapper<Cet4> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("headWord", cet4.getHeadword());
        if (cet4Dao.update(cet4, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    //    单词部分字段修改
    @Override
    public SaResult cet4modify(String word, String item, String keyword) {
        UpdateWrapper<Cet4> updateWrapper = new UpdateWrapper<>();
        Cet4 cet4 = new Cet4();
        if ("sentences".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            cet4.setSentences(item);
            if (cet4Dao.update(cet4, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("phrase".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            cet4.setPhrases(item);
            if (cet4Dao.update(cet4, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else {
            updateWrapper.eq("headWord", word);
            cet4.setSynos(item);
            if (cet4Dao.update(cet4, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }

//    Cet6

    @Override
    public SaResult cet6alldelete(String words) {
        QueryWrapper<Cet6> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(words.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的单词！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("headWord", words.split(",")[0]);
            if (cet6Dao.delete(wrapper) > 0) {
                return SaResult.ok(words.split(",")[0] + "已删除！");
            }
            return SaResult.error(words.split(",")[0] + "单词不存在！！");
        } else {
            wrapper.in("headWord", trueword);
            if (cet6Dao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选单词删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult cet6addword(Cet6 cet6) {
        if (cet6Dao.insert(cet6) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult cet6update(Cet6 cet6) {
        UpdateWrapper<Cet6> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("headWord", cet6.getHeadword());
        if (cet6Dao.update(cet6, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    @Override
    public SaResult cet6modify(String word, String item, String keyword) {
        UpdateWrapper<Cet6> updateWrapper = new UpdateWrapper<>();
        Cet6 cet6 = new Cet6();
        if ("sentences".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            cet6.setSentences(item);
            if (cet6Dao.update(cet6, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("phrase".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            cet6.setPhrases(item);
            if (cet6Dao.update(cet6, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else {
            updateWrapper.eq("headWord", word);
            cet6.setSynos(item);
            if (cet6Dao.update(cet6, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }


//    Chuzhong

    @Override
    public SaResult chuzhongalldelete(String words) {
        QueryWrapper<Chuzhong> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(words.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的单词！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("headWord", words.split(",")[0]);
            if (chuzhongDao.delete(wrapper) > 0) {
                return SaResult.ok(words.split(",")[0] + "已删除！");
            }
            return SaResult.error(words.split(",")[0] + "单词不存在！！");
        } else {
            wrapper.in("headWord", trueword);
            if (chuzhongDao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选单词删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult chuzhongaddword(Chuzhong chuzhong) {
        if (chuzhongDao.insert(chuzhong) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult chuzhongupdate(Chuzhong chuzhong) {
        //把名字为rhb的用户年龄更新为18，其他属性不变
        UpdateWrapper<Chuzhong> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("headWord", chuzhong.getHeadword());
        if (chuzhongDao.update(chuzhong, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    @Override
    public SaResult chuzhongmodify(String word, String item, String keyword) {
        UpdateWrapper<Chuzhong> updateWrapper = new UpdateWrapper<>();
        Chuzhong chuzhong = new Chuzhong();
        if ("sentences".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            chuzhong.setSentences(item);
            if (chuzhongDao.update(chuzhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("phrase".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            chuzhong.setPhrases(item);
            if (chuzhongDao.update(chuzhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else {
            updateWrapper.eq("headWord", word);
            chuzhong.setSynos(item);
            if (chuzhongDao.update(chuzhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }


//    Gaozhong

    @Override
    public SaResult gaozhongalldelete(String words) {
        QueryWrapper<Gaozhong> wrapper = new QueryWrapper<>();
        Collection<String> trueword = Arrays.asList(words.split(","));
        boolean wordjudge = false;
        if (trueword.size() == 0) {
            return SaResult.error("请选择要删除的单词！");
        }
        if (trueword.size() == 1) {
            wrapper.eq("headWord", words.split(",")[0]);
            if (gaozhongDao.delete(wrapper) > 0) {
                return SaResult.ok(words.split(",")[0] + "已删除！");
            }
            return SaResult.error(words.split(",")[0] + "单词不存在！！");
        } else {
            wrapper.in("headWord", trueword);
            if (gaozhongDao.delete(wrapper) > 0) {
                wordjudge = true;
            }
        }
        if (wordjudge) {
            return SaResult.ok("所选单词删除成功！");
        }
        return SaResult.error();
    }

    @Override
    public SaResult gaozhongaddword(Gaozhong gaozhong) {
        if (gaozhongDao.insert(gaozhong) > 0) {
            return SaResult.ok("添加成功");
        }
        return SaResult.error("添加失败！");
    }

    @Override
    public SaResult gaozhongupdate(Gaozhong gaozhong) {
        //把名字为rhb的用户年龄更新为18，其他属性不变
        UpdateWrapper<Gaozhong> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("headWord", gaozhong.getHeadword());
        if (gaozhongDao.update(gaozhong, updateWrapper) > 0) {
            return SaResult.ok("修改成功");
        }
        return SaResult.error("修改失败！");
    }

    @Override
    public SaResult gaozhongmodify(String word, String item, String keyword) {
        UpdateWrapper<Gaozhong> updateWrapper = new UpdateWrapper<>();
        Gaozhong gaozhong = new Gaozhong();
        if ("sentences".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            gaozhong.setSentences(item);
            if (gaozhongDao.update(gaozhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else if ("phrase".equals(keyword)) {
            updateWrapper.eq("headWord", word);
            gaozhong.setPhrases(item);
            if (gaozhongDao.update(gaozhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        } else {
            updateWrapper.eq("headWord", word);
            gaozhong.setSynos(item);
            if (gaozhongDao.update(gaozhong, updateWrapper) > 0) {
                return SaResult.ok("修改成功");
            }
        }
        return SaResult.error("修改失败！");
    }


}
