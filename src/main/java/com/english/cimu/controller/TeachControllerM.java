package com.english.cimu.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.english.cimu.ToneEntity.TbeanCollect;
import com.english.cimu.ToneEntity.Tone;
import com.english.cimu.service.impl.ToneServicelmplM;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/tt")
public class TeachControllerM {
    @Resource
    private ToneServicelmplM toneServicelmplM;

    @SaCheckLogin
    @GetMapping("/Tkone")
    public String getJson(Integer Trank) {
        Trank = (int) (Math.random() * 20) + 1;

        Tone tone = toneServicelmplM.getOneByTrank(Trank);
        Gson gson = new Gson();
        return gson.toJson(tone);
    }

    @SaCheckLogin
    @GetMapping("/TkonePd")
    public String getJsonByEg(String eg) {

        Tone tone = toneServicelmplM.getOneByEg(eg);
        Gson gson = new Gson();
        return gson.toJson(tone);
    }

    @SaCheckLogin
    @GetMapping("/Tktwo")
    public String getJsonTwo(Integer Trank) {
        Trank = (int) (Math.random() * 20) + 1;

        Tone tone = toneServicelmplM.getTwoByTrank(Trank);
        Gson gson = new Gson();
        return gson.toJson(tone);
    }

    @SaCheckLogin
    @GetMapping("/TktwoPd")
    public String getJsonTwoByEg(String eg) {

        Tone tone = toneServicelmplM.getTwoByEg(eg);
        Gson gson = new Gson();
        return gson.toJson(tone);
    }

    @SaCheckLogin
    @RequestMapping(value = "/TkoneCollect", method = RequestMethod.POST)
    public String ToneCollectByUsername(@RequestParam("eg") String eg, HttpSession httpSession) {
        // 获取登录后session 用户名 username
        String username = (String) httpSession.getAttribute("username");

        Tone tone = toneServicelmplM.getOneByEg(eg);
        TbeanCollect tbeanCollect = toneServicelmplM.getOneCollectByEg(eg);
        if (tbeanCollect != null) {
            return "该题目已在收藏夹！";
        } else {
            toneServicelmplM.InsertEg(username, tone.getTrank(), eg, tone.getRights(), tone.getAnalysis());
            return "收藏成功！请前往收藏夹查看！";
        }
    }

    @SaCheckLogin
    @RequestMapping(value = "/TktwoCollect", method = RequestMethod.POST)
    public String TtwoCollectByUsername(@RequestParam("eg") String eg, HttpSession httpSession) {
        // 获取登录后session 用户名 username
        String username = httpSession.getAttribute("username").toString();

        Tone tone = toneServicelmplM.getTwoByEg(eg);
        TbeanCollect tbeanCollect = toneServicelmplM.getOneCollectByEg(eg);
        if (tbeanCollect != null) {
            return "该题目已在收藏夹！";
        } else {
            toneServicelmplM.InsertEg(username, tone.getTrank(), eg, tone.getRights(), tone.getAnalysis());
            return "收藏成功！请前往收藏夹查看！";
        }

    }

    @SaCheckLogin
    @RequestMapping(value = "/TkoneDelCollect", method = RequestMethod.POST)
    public String ToneDelCollectByUsername(@RequestParam("eg") String eg, HttpSession httpSession) {
        // 获取登录后session 用户名 username
        String username = httpSession.getAttribute("username").toString();

        TbeanCollect tbeanCollect = toneServicelmplM.getOneCollectByEg(eg);

        if (tbeanCollect == null) {
            return "该题目不在收藏夹！";
        } else {
            toneServicelmplM.DeleteEg(username, eg);
            return "已取消收藏！";
        }

    }

}


