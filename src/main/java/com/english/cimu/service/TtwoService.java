package com.english.cimu.service;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.entity.Tone;
import com.english.cimu.entity.Ttwo;


/**
 * (Ttwo)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-31 00:52:39
 */
public interface TtwoService {

    TweiResult getTtwo(Page<Ttwo> page, String two);

    SaResult Ttwodelete(String two);

    SaResult Ttwoadd(Ttwo ttwo);

    SaResult Ttwomodify(String two, String item, String keyword);
}

