package com.english.cimu.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONObject;
import com.english.cimu.Encrypt.Md5Encrypt;
import com.english.cimu.Vo.UserVo;
import com.english.cimu.entity.*;
import com.english.cimu.model.UserChoose;
import com.english.cimu.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/10 2:50
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class MainApi {

    @Resource
    UserService userService;

    @Resource
    WordcollectionService wordcollectionService;

    @Resource
    Cet4Service cet4Service;

    @Resource
    Cet6Service cet6Service;

    @Resource
    ChuzhongService chuzhongService;

    @Resource
    GaozhongService gaozhongService;

    @Resource
    ReviewwordService reviewwordService;

    @Resource
    AchievementService achievementService;

    //    登录功能
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SaResult login(HttpSession session, @RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserVo userVo = userService.checkuser(user);

        if ("success".equals(userVo.getMessage())) {
            StpUtil.login(username);
            session.setAttribute("username", username);
            if (StpUtil.hasRole("super-admin")) {
                userVo.setMessage("location.href=('/twei/index')");
                return SaResult.data(userVo);
            }
            userVo.setMessage("location.href=('/home')");
            return SaResult.data(userVo);
        } else {
            return SaResult.data(userVo);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpSession session,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "emailcode") String emailcode) {
        if (emailcode.equals(session.getAttribute("email_code").toString())) {
            User user = new User();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(Md5Encrypt.EncoderByMd5(password, "acloudtwei"));
            user.setAuthority(0);
            user.setRegistertime(df.format(new Date(System.currentTimeMillis())));
            user.setRemarks("只是一个普通用户");
            if (userService.register(user)) {
                return "window.location.assign('/user/login')";
            }
        }
        return "alert('验证码错误！')";
    }

    @RequestMapping(value = "/forgetpsw", method = RequestMethod.POST)
    @ResponseBody
    public String forgetpsw(HttpSession session, @RequestParam(name = "email") String email, @RequestParam(name = "password") String changepassword,
                            @RequestParam(name = "verify") String verify) {
        if (verify.equals(session.getAttribute("email_code").toString())) {
            if (userService.forgetpsw(email, changepassword)) {
                return "success";
            }
            return "error";
        }
        return "验证码错误";
    }

    @RequestMapping(value = "/emailjudge", method = RequestMethod.GET)
    public Boolean emailjudge(@RequestParam(name = "email") String email) {
        return userService.emailjudge(email);
    }

    @RequestMapping(value = "/emailjudges", method = RequestMethod.GET)
    public Boolean emailjudges(@RequestParam(name = "email") String email) {
        return userService.emailjudges(email);
    }

    @RequestMapping(value = "/usernamejudge", method = RequestMethod.GET)
    public Boolean usernamejudge(@RequestParam(name = "username") String username) {
        return userService.usernamejudge(username);
    }

    @SaCheckLogin
    @RequestMapping(value = "/getmessage", method = RequestMethod.GET)
    public JSONObject getmessage(HttpSession session) {
        return userService.getmessage(session.getAttribute("username").toString());
    }

    @SaCheckLogin
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        StpUtil.logout();
        return "window.location.assign('/home')";
    }

    //    背单词功能
    @SaCheckLogin
    @RequestMapping(value = "/getcet4", method = RequestMethod.POST)
    public Cet4 getcet4(HttpSession session, @RequestParam(name = "wordtype") String wordtype) {
        UserChoose userChoose = new UserChoose();
        userChoose.setUsername(session.getAttribute("username").toString());
        userChoose.setWordtype(wordtype);
        session.setAttribute("wordtype", wordtype);
        return cet4Service.randomone(userChoose);
    }

    @SaCheckLogin
    @RequestMapping(value = "/getcet6", method = RequestMethod.POST)
    public Cet6 getcet6(HttpSession session, @RequestParam(name = "wordtype") String wordtype) {
        UserChoose userChoose = new UserChoose();
        userChoose.setUsername(session.getAttribute("username").toString());
        userChoose.setWordtype(wordtype);
        session.setAttribute("wordtype", wordtype);
        return cet6Service.randomone(userChoose);
    }

    @SaCheckLogin
    @RequestMapping(value = "/getchuzhong", method = RequestMethod.POST)
    public Chuzhong getchuzhong(HttpSession session, @RequestParam(name = "wordtype") String wordtype) {
        UserChoose userChoose = new UserChoose();
        userChoose.setUsername(session.getAttribute("username").toString());
        userChoose.setWordtype(wordtype);
        session.setAttribute("wordtype", wordtype);
        return chuzhongService.randomone(userChoose);
    }

    @SaCheckLogin
    @RequestMapping(value = "/getgaozhong", method = RequestMethod.POST)
    public Gaozhong getgaozhong(HttpSession session, @RequestParam(name = "wordtype") String wordtype) {
        UserChoose userChoose = new UserChoose();
        userChoose.setUsername(session.getAttribute("username").toString());
        userChoose.setWordtype(wordtype);
        session.setAttribute("wordtype", wordtype);
        return gaozhongService.randomone(userChoose);
    }

//    复习功能

    @SaCheckLogin
    @RequestMapping(value = "/getreviewwordmessage", method = RequestMethod.GET)
    public JSONObject getreviewwordmessage(HttpSession session) {
        return reviewwordService.getwordmessage(session.getAttribute("username").toString(),
                session.getAttribute("wordtype").toString());
    }

    @SaCheckLogin
    @RequestMapping(value = "/getreviewupdatelearn", method = RequestMethod.POST)
    public Boolean getreviewupdatelearn(HttpSession session, @RequestParam(name = "word") String word) {
        return reviewwordService.updatelearn(session.getAttribute("username").toString(), word);
    }

//    收藏功能

    @SaCheckLogin
    @PostMapping("addcollection")
    public String addcollection(HttpSession session, @RequestParam(name = "word") String word) {
        if (wordcollectionService.judgeword(word)) {
            Wordcollection wordcollection = new Wordcollection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            wordcollection.setUsername(session.getAttribute("username").toString());
            wordcollection.setWord(word);
            wordcollection.setCollecttime(df.format(new Date(System.currentTimeMillis())));
            if (wordcollectionService.addcollection(wordcollection)) {
                return "alert('收藏成功！')";
            }
            return "alert('收藏失败！')";
        }
        return "alert('单词已存在！')";
    }

    @SaCheckLogin
    @PostMapping("deletecollection")
    public String deletecollection(HttpSession session, @RequestParam(name = "word") String word) {
        if (!wordcollectionService.judgeword(word)) {
            Wordcollection wordcollection = new Wordcollection();
            wordcollection.setUsername(session.getAttribute("username").toString());
            wordcollection.setWord(word);
            if (wordcollectionService.deletecollection(wordcollection)) {
                return "alert('删除成功！')";
            }
            return "alert('删除失败！')";
        }
        return "alert('单词未收藏！')";
    }

    @SaCheckLogin
    @GetMapping("getallword")
    public List<String> getallword(HttpSession session) {
        return wordcollectionService.getallword(session.getAttribute("username").toString());
    }

    @SaCheckLogin
    @GetMapping("getwordmessage")
    public List<JSONObject> getwordmessage(HttpSession session) {
        return wordcollectionService.getwordmessage(session.getAttribute("username").toString());
    }

//    成就功能

    @SaCheckLogin
    @GetMapping("getrank")
    public JSONObject getrank(HttpSession session) {
        return achievementService.getrank(session.getAttribute("username").toString(), session.getAttribute("wordtype").toString());
    }

}
