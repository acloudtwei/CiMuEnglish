package com.english.cimu.service;

import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.entity.Tcoll;

import java.util.List;

public interface TcollService {
    List<TbeanCollect> Selecttcoll(String username);
}
