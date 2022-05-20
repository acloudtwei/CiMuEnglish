package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.util.SaResult;
import com.english.cimu.Utils.YouDaoApi;
import com.english.cimu.model.QueryWords;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/9 8:51
 */

@RestController
@RequestMapping(value = "/query", method = RequestMethod.POST)
public class QueryApi {

    @Resource
    YouDaoApi youDaoApi;

    @SaCheckLogin
    @PostMapping("/word")
    public QueryWords word(@RequestParam(name = "word") String word) {
        return youDaoApi.queryword(word);
    }

    @SaCheckLogin
    @PostMapping("/translate")
    public String translate(@RequestParam(name = "sentence") String sentence) {
        return youDaoApi.querytranslate(sentence);
    }
}
