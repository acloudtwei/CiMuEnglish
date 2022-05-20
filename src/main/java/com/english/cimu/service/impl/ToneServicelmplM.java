package com.english.cimu.service.impl;

import com.english.cimu.Tmapper.TcollectMapper;
import com.english.cimu.Tmapper.ToneMapper;
import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.ToneEntity.Tone;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ToneServicelmplM {
    @Resource
    ToneMapper toneMapper;
    @Resource
    TcollectMapper tcollectMapper;
    public Tone getOneByTrank(int Trank)
    {
        return toneMapper.getOneByTrank(Trank);
    }

    public Tone getOneByEg(String eg)
    {
        return toneMapper.getOneByEg(eg);
    }

    public Tone getTwoByTrank(int Trank)
    {
        return toneMapper.getTwoByTrank(Trank);
    }

    public Tone getTwoByEg(String eg)
    {
        return toneMapper.getTwoByEg(eg);
    }


    public TbeanCollect getOneCollectByEg(String eg)
    {
        return tcollectMapper.getOneCollectByEg(eg);
    }


    public void InsertEg(String username,int Trank, String eg, String Cright, String analysis){
        tcollectMapper.InsertEg(username,Trank,eg,Cright,analysis);
    }
    public void DeleteEg(String username,String eg){
        tcollectMapper.DeleteEg(username,eg);
    }


}
