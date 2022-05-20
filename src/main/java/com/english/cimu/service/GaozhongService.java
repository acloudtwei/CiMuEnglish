package com.english.cimu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.english.cimu.entity.Gaozhong;
import com.english.cimu.model.UserChoose;

/**
 * (Gaozhong)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-11 08:50:46
 */
public interface GaozhongService{

    Gaozhong randomone(UserChoose userChoose);
}

