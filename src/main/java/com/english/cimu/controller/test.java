package com.english.cimu.controller;

import cn.hutool.json.JSON;
import com.english.cimu.Utils.QueryWord;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.Utils.YouDaoApi;
import com.english.cimu.dao.WordcollectionDao;
import com.english.cimu.entity.Chuzhong;
import com.english.cimu.entity.Wordcollection;
import com.english.cimu.model.QueryWords;
import com.english.cimu.service.WordcollectionService;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/6 19:18
 */
@RestController
public class test {

    @Resource
    YouDaoApi youDaoApi;

    @GetMapping("danci")
    public QueryWords danci() {
        return youDaoApi.queryword("people");
    }

    @GetMapping("fanysi")
    public String fanyi() {
        return youDaoApi.querytranslate("今天心情不好，烦死了");
    }

    @GetMapping("fanysis")
    public String fanysis() {
        return youDaoApi.querytranslate("I'm in a bad mood today. I'm bored to death.");
    }

    @GetMapping("twei")
    public TweiResult tweiresult() {
        return TweiResult.ok(100,":aa");
    }

}
