package com.english.cimu.controller;

import cn.dev33.satoken.stp.StpUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author acloudtwei
 * @since 2021-12-06 16:55:21
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        if (StpUtil.isLogin()) {
            return "main";
        }
        return "login/login";
    }

//    @RequestMapping(value = "*", method = RequestMethod.GET)
//    public String notFound() {
//        return "404";
//    }
}

