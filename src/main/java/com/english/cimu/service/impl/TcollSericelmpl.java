package com.english.cimu.service.impl;

import com.english.cimu.Tmapper.TcollMapper;
import com.english.cimu.Tmapper.TcollectMapper;
import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.entity.Tcoll;
import com.english.cimu.service.TcollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TcollSericelmpl implements TcollService {

    @Resource
    TcollectMapper tcollectMapper;
    @Override
    public List<TbeanCollect> Selecttcoll(String username) {
        return tcollectMapper.SelectTcoll(username);
    }
}
