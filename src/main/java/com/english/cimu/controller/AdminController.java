package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2022/1/1 20:23
 */
@Controller
@RequestMapping(value = "/twei")
public class AdminController {

    @RequestMapping("/addeducation")
    public String addeducation() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/table/addeducation";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/adduser")
    public String adduser() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/table/adduser";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/addword")
    public String addword() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/table/addword";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/editword")
    public String editword() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/table/editword";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/usertable")
    public String usertable() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/usertable";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/cet4table")
    public String cet4table() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/cet4table";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/cet6table")
    public String cet6table() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/cet6table";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/chuzhongtable")
    public String chuzhongtable() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/chuzhongtable";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/gaozhongtable")
    public String gaozhongtable() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/gaozhongtable";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/educationOne")
    public String educationOne() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/educationOne";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/educationTwo")
    public String educationTwo() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/educationTwo";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/index")
    public String index() {
//        StpUtil.getLoginId();
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/index";
            }
            return "404";
        }
        return "login/login";
    }


    @RequestMapping("/welcome")
    public String adminwelcome() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/welcome";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/userpassword")
    public String userpassword() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/user-password";
            }
            return "404";
        }
        return "login/login";
    }

    @RequestMapping("/usersetting")
    public String usersetting() {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole("super-admin")) {
                return "admin/user-setting";
            }
            return "404";
        }
        return "login/login";
    }

}
