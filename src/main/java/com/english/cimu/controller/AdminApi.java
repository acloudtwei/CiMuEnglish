package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.english.cimu.Utils.TweiResult;
import com.english.cimu.entity.*;
import com.english.cimu.service.AdminService;
import com.english.cimu.service.ToneService;
import com.english.cimu.service.TtwoService;
import com.english.cimu.service.WordsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/28 21:42
 */
@RestController
@RequestMapping(value = "/twei", method = RequestMethod.POST)
public class AdminApi {

    @Resource
    WordsService wordsService;

    @Resource
    ToneService toneService;

    @Resource
    TtwoService ttwoService;

    @Resource
    AdminService adminService;

    //    单词后台接口
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getcet4words", method = RequestMethod.POST)
    public TweiResult getcet4words(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                                   @RequestParam(name = "limit", defaultValue = "10") int limit,
                                   @RequestParam(name = "word", defaultValue = "") String word) {
        Page<Cet4> paged = new Page<>(page, limit);
        return wordsService.getcet4words(paged, word);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getcet6words", method = RequestMethod.POST)
    public TweiResult getcet6words(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                                   @RequestParam(name = "limit", defaultValue = "10") int limit,
                                   @RequestParam(name = "word", defaultValue = "") String word) {
        Page<Cet6> paged = new Page<>(page, limit);
        return wordsService.getcet6words(paged, word);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getchuzhongwords", method = RequestMethod.POST)
    public TweiResult getchuzhongwords(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                                       @RequestParam(name = "limit", defaultValue = "10") int limit,
                                       @RequestParam(name = "word", defaultValue = "") String word) {
        Page<Chuzhong> paged = new Page<>(page, limit);
        return wordsService.getchuzhongwords(paged, word);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getgaozhongwords", method = RequestMethod.POST)
    public TweiResult getgaozhongwords(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                                       @RequestParam(name = "limit", defaultValue = "10") int limit,
                                       @RequestParam(name = "word", defaultValue = "") String word) {
        Page<Gaozhong> paged = new Page<>(page, limit);
        return wordsService.getgaozhongwords(paged, word);
    }

//    cet4
//    下面是删除操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet4alldelete", method = RequestMethod.POST)
    public SaResult cet4alldelete(HttpSession session,
                                  @RequestParam(name = "words", defaultValue = "") String words) {
        return wordsService.cet4alldelete(words);
    }

//    下面是添加操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet4addword", method = RequestMethod.POST)
    public SaResult cet4addword(HttpSession session,
                                @RequestBody Cet4 cet4) {
        return wordsService.cet4addword(cet4);
    }

//    下面是编辑操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet4update", method = RequestMethod.POST)
    public SaResult cet4update(HttpSession session,
                               @RequestBody Cet4 cet4) {
        return wordsService.cet4update(cet4);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet4modify", method = RequestMethod.POST)
    public SaResult cet4modify(HttpSession session,
                               @RequestParam(name = "word") String word,
                               @RequestParam(name = "item") String item,
                               @RequestParam(name = "keyword") String keyword) {
        return wordsService.cet4modify(word, item, keyword);
    }


//    cet6
//    下面是删除操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet6alldelete", method = RequestMethod.POST)
    public SaResult cet6alldelete(HttpSession session,
                                  @RequestParam(name = "words", defaultValue = "") String words) {
        return wordsService.cet6alldelete(words);
    }

//    下面是添加操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet6addword", method = RequestMethod.POST)
    public SaResult cet6addword(HttpSession session,
                                @RequestBody Cet6 cet6) {
        return wordsService.cet6addword(cet6);
    }

//    下面是编辑操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet6update", method = RequestMethod.POST)
    public SaResult cet6update(HttpSession session,
                               @RequestBody Cet6 cet6) {
        return wordsService.cet6update(cet6);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/cet6modify", method = RequestMethod.POST)
    public SaResult cet6modify(HttpSession session,
                               @RequestParam(name = "word") String word,
                               @RequestParam(name = "item") String item,
                               @RequestParam(name = "keyword") String keyword) {
        return wordsService.cet6modify(word, item, keyword);
    }

    //    chuzhong
//    下面是删除操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/chuzhongalldelete", method = RequestMethod.POST)
    public SaResult chuzhongalldelete(HttpSession session,
                                      @RequestParam(name = "words", defaultValue = "") String words) {
        return wordsService.chuzhongalldelete(words);
    }

//    下面是添加操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/chuzhongaddword", method = RequestMethod.POST)
    public SaResult chuzhongaddword(HttpSession session,
                                    @RequestBody Chuzhong chuzhong) {
        return wordsService.chuzhongaddword(chuzhong);
    }

//    下面是编辑操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/chuzhongupdate", method = RequestMethod.POST)
    public SaResult chuzhongupdate(HttpSession session,
                                   @RequestBody Chuzhong chuzhong) {
        return wordsService.chuzhongupdate(chuzhong);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/chuzhongmodify", method = RequestMethod.POST)
    public SaResult chuzhongmodify(HttpSession session,
                                   @RequestParam(name = "word") String word,
                                   @RequestParam(name = "item") String item,
                                   @RequestParam(name = "keyword") String keyword) {
        return wordsService.chuzhongmodify(word, item, keyword);
    }


//    下面是删除操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/gaozhongalldelete", method = RequestMethod.POST)
    public SaResult gaozhongalldelete(HttpSession session,
                                      @RequestParam(name = "words", defaultValue = "") String words) {
        return wordsService.gaozhongalldelete(words);
    }

//    下面是添加操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/gaozhongaddword", method = RequestMethod.POST)
    public SaResult gaozhongaddword(HttpSession session,
                                    @RequestBody Gaozhong gaozhong) {
        return wordsService.gaozhongaddword(gaozhong);
    }

//    下面是编辑操作

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/gaozhongupdate", method = RequestMethod.POST)
    public SaResult gaozhongupdate(HttpSession session,
                                   @RequestBody Gaozhong gaozhong) {
        return wordsService.gaozhongupdate(gaozhong);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/gaozhongmodify", method = RequestMethod.POST)
    public SaResult gaozhongmodify(HttpSession session,
                                   @RequestParam(name = "word") String word,
                                   @RequestParam(name = "item") String item,
                                   @RequestParam(name = "keyword") String keyword) {
        return wordsService.gaozhongmodify(word, item, keyword);
    }

//    教育资格证后台接口

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getTone", method = RequestMethod.POST)
    public TweiResult getTone(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                              @RequestParam(name = "limit", defaultValue = "5") int limit,
                              @RequestParam(name = "one", defaultValue = "") String one) {
        Page<Tone> paged = new Page<>(page, limit);
        return toneService.getTone(paged, one);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Tonedelete", method = RequestMethod.POST)
    public SaResult Tonedelete(HttpSession session,
                               @RequestParam(name = "one", defaultValue = "") String one) {
        return toneService.Tonedelete(one);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Toneadd", method = RequestMethod.POST)
    public SaResult Toneadd(HttpSession session,
                            @RequestBody Tone tone) {
        return toneService.Toneadd(tone);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Tonemodify", method = RequestMethod.POST)
    public SaResult Tonemodify(HttpSession session,
                               @RequestParam(name = "one") String one,
                               @RequestParam(name = "item") String item,
                               @RequestParam(name = "keyword") String keyword) {
        return toneService.Tonemodify(one, item, keyword);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getTtwo", method = RequestMethod.POST)
    public TweiResult getTtwo(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                              @RequestParam(name = "limit", defaultValue = "5") int limit,
                              @RequestParam(name = "two", defaultValue = "") String two) {
        Page<Ttwo> paged = new Page<>(page, limit);
        return ttwoService.getTtwo(paged, two);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Ttwodelete", method = RequestMethod.POST)
    public SaResult Ttwodelete(HttpSession session,
                               @RequestParam(name = "two", defaultValue = "") String two) {
        return ttwoService.Ttwodelete(two);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Ttwoadd", method = RequestMethod.POST)
    public SaResult Ttwoadd(HttpSession session,
                            @RequestBody Ttwo ttwo) {
        return ttwoService.Ttwoadd(ttwo);
    }

    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/Ttwomodify", method = RequestMethod.POST)
    public SaResult Ttwomodify(HttpSession session,
                               @RequestParam(name = "two") String two,
                               @RequestParam(name = "item") String item,
                               @RequestParam(name = "keyword") String keyword) {
        return ttwoService.Ttwomodify(two, item, keyword);
    }

    //    数据统计接口
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getsumdata", method = RequestMethod.POST)
    public SaResult getsumdata(HttpSession session) {
        return adminService.getsumdata();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public SaResult admin(HttpSession session) {
        if (StpUtil.hasRole("super-admin")) {
            return SaResult.ok("okok");
        }
        return SaResult.error();
    }

    //    获取用户信息接口
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public TweiResult getusers(HttpSession session, @RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "limit", defaultValue = "5") int limit) {
        Page<User> paged = new Page<>(page, limit);
        return adminService.getusers(paged);
    }

    //    密码转化器
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/topassword", method = RequestMethod.POST)
    public SaResult topassword(HttpSession session, @RequestParam(name = "password") String password) {
        return adminService.topassword(password);
    }

    //    权限修改
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/toauthority", method = RequestMethod.POST)
    public SaResult toauthority(HttpSession session, @RequestBody User user) {
        return adminService.toauthority(user);
    }

    //    备注修改
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/tomodify", method = RequestMethod.POST)
    public SaResult tomodify(HttpSession session, @RequestParam(name = "username") String username,
                             @RequestParam(name = "item") String item) {
        return adminService.tomodify(username, item);
    }

    //用户删除
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/toalldelete", method = RequestMethod.POST)
    public SaResult toalldelete(HttpSession session,
                                @RequestParam(name = "username") String username) {
        return adminService.toalldelete(username);
    }

    //    添加用户
    @SaCheckLogin
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/toadduser", method = RequestMethod.POST)
    public SaResult toadduser(HttpSession session,
                              @RequestBody User user) {
        return adminService.toadduser(user);
    }

    //更新资料
    @SaCheckLogin
    @CrossOrigin("*")
    @RequestMapping(value = "/updatemessage", method = RequestMethod.POST)
    public SaResult updatemessage(HttpSession session,
                                  @RequestBody JSONObject jsonObject) {

        return adminService.updatemessage(jsonObject.getStr("nowusername"),
                JSONUtil.toBean(jsonObject.getStr("userdata"), User.class));
    }

    //更新密码
    @SaCheckLogin
    @CrossOrigin("*")
    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    public SaResult updatepassword(HttpSession session,
                                   @RequestParam(name = "username") String username,
                                   @RequestParam(name = "password") String password) {
        return adminService.updatepassword(username, password);
    }

    @SaCheckLogin
    @CrossOrigin("*")
    @RequestMapping(value = "/judgeuser", method = RequestMethod.GET)
    public SaResult judgeuser() {
        return adminService.judgeuser();
    }

}
    