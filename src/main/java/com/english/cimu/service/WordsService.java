package com.english.cimu.service;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.entity.*;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/29 1:50
 */

public interface WordsService {

//    TweiResult getallwords(Page<Words> page, String word);

    TweiResult getcet4words(Page<Cet4> page, String word);

    TweiResult getcet6words(Page<Cet6> page, String word);

    TweiResult getchuzhongwords(Page<Chuzhong> page, String word);

    TweiResult getgaozhongwords(Page<Gaozhong> page, String word);

    SaResult cet4alldelete(String words);

    SaResult cet4addword(Cet4 cet4);

    SaResult cet4update(Cet4 cet4);

    SaResult cet4modify(String word, String item, String keyword);

    SaResult cet6alldelete(String words);

    SaResult cet6addword(Cet6 cet6);

    SaResult cet6update(Cet6 cet6);

    SaResult cet6modify(String word, String item, String keyword);

    SaResult chuzhongalldelete(String words);

    SaResult chuzhongaddword(Chuzhong chuzhong);

    SaResult chuzhongupdate(Chuzhong chuzhong);

    SaResult chuzhongmodify(String word, String item, String keyword);

    SaResult gaozhongalldelete(String words);

    SaResult gaozhongaddword(Gaozhong gaozhong);

    SaResult gaozhongupdate(Gaozhong gaozhong);

    SaResult gaozhongmodify(String word, String item, String keyword);
}
