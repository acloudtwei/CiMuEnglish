package com.english.cimu.service;

import com.english.cimu.entity.Wordcollection;
import cn.hutool.json.JSONObject;

import java.util.List;


/**
 * (Wordcollection)表服务接口
 *
 * @author acloudtwei
 * @since 2021-12-10 10:46:20
 */
public interface WordcollectionService {

    Boolean addcollection(Wordcollection wordcollection);

    Boolean judgeword(String word);

    Boolean deletecollection(Wordcollection wordcollection);

    List<String> getallword(String username);

    List<JSONObject> getwordmessage(String username);

}

