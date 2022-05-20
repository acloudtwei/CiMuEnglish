package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.english.cimu.mapper.PthArticleMapper;
import com.english.cimu.mapper.PthDataMapper;
import com.english.cimu.mapper.PthErMapper;
import com.english.cimu.mapper.PthWordMapper;
import com.english.cimu.model.ptharticle;
import com.english.cimu.model.pthdata;
import com.english.cimu.model.pther;
import com.english.cimu.model.pthword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class pth {
    pthword a;
    ptharticle b;
    pther c;

    @Autowired
    private PthWordMapper pthWordMapper;
    @Autowired
    private PthArticleMapper pthArticleMapper;
    @Autowired
    private PthErMapper pthErMapper;
    @Autowired
    private PthDataMapper pthDataMapper;


    //
    @SaCheckLogin
    @RequestMapping("/getpthword0")
    @ResponseBody
    public List<pthword> getpthwords() {
        System.out.println(pthWordMapper.selectList(null));
        return pthWordMapper.selectList(null);
    }

    @SaCheckLogin
    @RequestMapping("/topthword1")
    @ResponseBody
    public String pthwords(String name) {
        System.out.println(name);
        a = pthWordMapper.selectById(name);
        System.out.println(a);
        return "/pthword1";
    }

    @SaCheckLogin
    @RequestMapping("/getpthword1")
    @ResponseBody
    public pthword getpthword() {
        System.out.println(a);
        return a;
    }

    @SaCheckLogin
    @RequestMapping("/getpther0")
    @ResponseBody
    public List<pther> getpther0() {
        System.out.println(pthErMapper.selectList(null));
        return pthErMapper.selectList(null);
    }

    @SaCheckLogin
    @RequestMapping("/topther1")
    @ResponseBody
    public String topther1(String name) {
        System.out.println(name);
        c = pthErMapper.selectById(name);
        System.out.println(c);
        return "/pther1";
    }

    @SaCheckLogin
    @RequestMapping("/getpther1")
    @ResponseBody
    public pther getpther1() {
        System.out.println(c);
        return c;
    }

    @SaCheckLogin
    @RequestMapping("/getptharticle0")
    @ResponseBody
    public List<ptharticle> getptharticle0() {
        System.out.println(pthArticleMapper.selectList(null));
        return pthArticleMapper.selectList(null);
    }

    @SaCheckLogin
    @RequestMapping("/toptharticle1")
    @ResponseBody
    public String toptharticle1(String name) {
        System.out.println(name);
        b = pthArticleMapper.selectById(name);
        System.out.println(b);
        return "/ptharticle1";
    }


    @SaCheckLogin
    @RequestMapping("/getptharticle1")
    @ResponseBody
    public ptharticle getptharticle1() {
        System.out.println(b);
        return b;
    }

    @SaCheckLogin
    @RequestMapping("/getpthdata0")
    @ResponseBody
    public List<pthdata> getpthdata0() {
        System.out.println(pthDataMapper.selectList(null));
        return pthDataMapper.selectList(null);
    }

    @RequestMapping("/pther1")
    public String pther1() {
        if (StpUtil.isLogin()) {
            return "pth/pther1";
        }
        return "login/login";
    }

    @RequestMapping("/ptharticle1")
    public String ptharticle1() {
        if (StpUtil.isLogin()) {
            return "pth/ptharticle1";
        }
        return "login/login";
    }

    @RequestMapping("/pthword1")
    public String pthword() {
        if (StpUtil.isLogin()) {
            return "pth/pthword1";
        }
        return "login/login";
    }

    @RequestMapping("/topthword0")
    public String topthword0() {
        if (StpUtil.isLogin()) {
            return "pth/pthword0";
        }
        return "login/login";
    }

    @RequestMapping("/topthartice0")
    public String toptharticle0() {
        if (StpUtil.isLogin()) {
            return "pth/ptharticle0";
        }
        return "login/login";
    }

    @RequestMapping("/topther0")
    public String topther0() {
        if (StpUtil.isLogin()) {
            return "pth/pther0";
        }
        return "login/login";
    }

    @RequestMapping("/topthdata0")
    public String topthdata0() {
        if (StpUtil.isLogin()) {
            return "pth/pthdata0";
        }
        return "login/login";
    }


    @RequestMapping("/pthword0")
    public String index() {
        if (StpUtil.isLogin()) {
            return "pth/pthword0";
        }
        return "login/login";
    }

    @RequestMapping("/topthindex")
    public String topthindex() {
        if (StpUtil.isLogin()) {
            return "pth/pthindex";
        }
        return "login/login";
    }
}
