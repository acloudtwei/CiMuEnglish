package com.english.cimu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.english.cimu.entity.Tone;

import org.apache.ibatis.annotations.Mapper;

/**
 * (Tone)表数据库访问层
 *
 * @author acloudtwei
 * @since 2021-12-30 23:59:10
 */
@Mapper
public interface ToneDao extends BaseMapper<Tone> {

}

