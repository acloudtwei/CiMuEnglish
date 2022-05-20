package com.english.cimu.Tmapper;


import com.english.cimu.ToneEntity.Tone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ToneMapper {
    @Select("select * from tone where Trank = #{Trank}")
    public Tone getOneByTrank(Integer Trank);

    @Select("select * from tone where eg = #{eg}")
    public Tone getOneByEg(String eg);

    @Select("select * from ttwo where Trank = #{Trank}")
    public Tone getTwoByTrank(Integer Trank);

    @Select("select * from ttwo where eg = #{eg}")
    public Tone getTwoByEg(String eg);

}


