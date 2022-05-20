package com.english.cimu.service.impl;

import com.english.cimu.service.MailInterface;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;


/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/10/13 23:46
 */

/**
 * 最简单的邮件发送
 * <p>
 * 'to'      接收方
 * 'subject' 标题
 * 'content' 内容
 */

@Service

public class MailServiceImpl implements MailInterface {

    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(new InternetAddress(MimeUtility.encodeText("Acloudtwei") + "<acloudcc@qq.com>").toString());
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String sendHtmlMail(String to, String subject, String content) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(new InternetAddress(MimeUtility.encodeText("大学生考证辅助平台") + "<acloudcc@qq.com>").toString());
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setSubject(subject);
            mailSender.send(mimeMessage);
            return "success";
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return "error";
        }
    }
}


