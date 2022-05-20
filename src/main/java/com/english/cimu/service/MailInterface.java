package com.english.cimu.service;
import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;

/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/10/16 13:48
 */
public interface MailInterface {

    public void sendSimpleMail(String to, String subject, String content) throws UnsupportedEncodingException, AddressException;

    public String sendHtmlMail(String to, String subject, String content);
}
