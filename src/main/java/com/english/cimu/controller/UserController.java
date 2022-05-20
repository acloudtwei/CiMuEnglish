package com.english.cimu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/10 2:11
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/findpassword")
    public String find() {
        return "login/findpassword";
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }
}
