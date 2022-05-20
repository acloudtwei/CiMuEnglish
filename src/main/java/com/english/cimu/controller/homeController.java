package com.english.cimu.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/home")
    public String Tmain() {
        return "home";
    }

    @RequestMapping("/myspace")
    public String myspace() {
        if (StpUtil.isLogin()) {
            return "myspace";
        }
        return "login/login";
    }

}
