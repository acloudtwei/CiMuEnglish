package com.english.cimu.controller;

import com.english.cimu.Encrypt.RsaEncrypt;
import com.english.cimu.model.JsonModel;
import com.english.cimu.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/10/30 12:44
 */

@Controller
@RequestMapping(value = "/mail", method = RequestMethod.GET)
public class MailApi {



    @Value("${privateKey}")
    private String privateKey;

    @Resource
    private MailServiceImpl mailService;

    @Resource
    private TemplateEngine templateEngine;

    @GetMapping("/session")
    @ResponseBody
    public String cpdd(HttpSession session) {
        return session.getAttribute("email_code").toString();
    }

    private Boolean MailSendTemplate(String code, String email, String message) {

        email = RsaEncrypt.decode(email, this.privateKey);
        if (email == null) {
            return false;
        }
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("code", code);
        String mail = templateEngine.process("/email/emailTemplate.html", context);
        String status = mailService.sendHtmlMail(email, "【邮箱验证码】", mail);
        return "success".equals(status);
    }

    @GetMapping("/register")
    @ResponseBody
    public JsonModel register(HttpSession session, @RequestParam(name = "email") String email) {
        JsonModel jsonModel = new JsonModel();
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println(code);
//        MailSendTemplate(code, email, "注册")
        if (MailSendTemplate(code, email, "注册")) {
            session.setAttribute("email_code", code);
            jsonModel.setCode(200);
            jsonModel.setSuccess(true);
            jsonModel.setMessage("发送成功");
        } else {
            jsonModel.setCode(100);
            jsonModel.setSuccess(false);
            jsonModel.setMessage("接口已加密，请勿乱用！");
        }
        return jsonModel;
    }

    @GetMapping("/login")
    @ResponseBody
    public JsonModel login(HttpSession session, @RequestParam(name = "email") String email) {
        JsonModel jsonModel = new JsonModel();
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println(code);
        if (MailSendTemplate(code, email, "登录")) {
            session.setAttribute("email_code", code);
            jsonModel.setCode(200);
            jsonModel.setSuccess(true);
            jsonModel.setMessage("发送成功");
        } else {
            jsonModel.setCode(100);
            jsonModel.setSuccess(false);
            jsonModel.setMessage("接口已加密，请勿乱用！");
        }
        System.out.println(code);
        return jsonModel;
    }

    @GetMapping("/forget")
    @ResponseBody
    public JsonModel forget(HttpSession session, @RequestParam(name = "email") String email) {
        JsonModel jsonModel = new JsonModel();
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println(code);
        if (MailSendTemplate(code, email, "忘记密码")) {
            session.setAttribute("email_code", code);
            jsonModel.setCode(200);
            jsonModel.setSuccess(true);
            jsonModel.setMessage("发送成功");
        } else {
            jsonModel.setCode(100);
            jsonModel.setSuccess(false);
            jsonModel.setMessage("接口已加密，请勿乱用！");
        }
        return jsonModel;
    }


//    @GetMapping("/logins")
//    @ResponseBody
//    public JsonModel logins() {
//        JsonModel jsonModel = new JsonModel();
//        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
//        System.out.println(code);
//        if (MailSendTemplate(code, "1559295172@qq.com", "登录")) {
//            jsonModel.setCode(200);
//            jsonModel.setSuccess(true);
//            jsonModel.setMessage("发送成功");
//        } else {
//            jsonModel.setCode(100);
//            jsonModel.setSuccess(false);
//            jsonModel.setMessage("接口已加密，请勿乱用！");
//        }
//        System.out.println(code);
//        return jsonModel;
//    }
}