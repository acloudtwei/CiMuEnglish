package com.english.cimu.Tmapper;


import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.ToneEntity.Tone;
import com.english.cimu.entity.Tcoll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  TcollectMapper {

    @Select("select * from tcollection where eg = #{eg}")
    public TbeanCollect getOneCollectByEg(@Param("eg") String eg);

    @Insert("insert into tcollection (username,Trank,eg,Cright,analysis) values(#{username},#{Trank},#{eg},#{Cright},#{analysis})")
    void InsertEg(@Param("username")String username,
                  @Param("Trank")int Trank,
                  @Param("eg") String eg,
                  @Param("Cright") String Cright,
                  @Param("analysis")String analysis);
    @Delete("delete from tcollection where username = #{username} and eg = #{eg}")
    void DeleteEg(@Param("username")String username,@Param("eg") String eg);

    @Select("select username,Trank,eg,Cright,analysis from tcollection where username = #{username}")
    List<TbeanCollect> SelectTcoll(@Param("username") String username);
}
