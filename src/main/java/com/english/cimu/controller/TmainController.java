package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TmainController {


    @RequestMapping("/Tmain")
    public String Tmain() {
        if (StpUtil.isLogin()) {
            return "Teacher/Tmain";
        }
        return "login/login";
    }

    @RequestMapping("/Tone")
    public String Tkone() {
        if (StpUtil.isLogin()) {
            return "Teacher/Tkone";
        }
        return "login/login";
    }

    @SaCheckLogin
    @RequestMapping("/Ttwo")
    public String Tktwo() {
        if (StpUtil.isLogin()) {
            return "Teacher/Tktwo";
        }
        return "login/login";
    }

    @SaCheckLogin
    @RequestMapping("/Tcollect")
    public String Tcollect() {
        if (StpUtil.isLogin()) {
            return "Teacher/Tcollect";
        }
        return "login/login";
    }

    @SaCheckLogin
    @RequestMapping("/Tziliao")
    public String Tziliao() {
        if (StpUtil.isLogin()) {
            return "Teacher/Tziliao";
        }
        return "login/login";
    }
}
