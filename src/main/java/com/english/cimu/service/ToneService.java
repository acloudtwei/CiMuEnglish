package com.english.cimu.service;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.entity.Cet4;
import com.english.cimu.entity.Tone;


/**
 * (Tone)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-30 23:59:10
 */
public interface ToneService {

    TweiResult getTone(Page<Tone> page, String one);

    SaResult Tonedelete(String one);

    SaResult Toneadd(Tone tone);

    SaResult Tonemodify(String one, String item, String keyword);

}

