package com.lhb.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author: yaya
 * @create: 2020/4/2
 * 邮件发送工具类
 */
public class MailUtil {
    public void sendEmail(JavaMailSenderImpl mailSender,String fromMail,String toMail,String validateCode,String username)throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        String content =
                "<p style='text-indent:2em;line-height:60px;'>" +
                "尊敬的<span style='color:aqua;font-size:24px;'>" +username+"</span>"+
                "您好!</p>" +
                "<p style='line-height:60px;'>" +
                "您的验证码为：<span style='color:red;font-size:24px;'>" +validateCode+
                "</span>,请保管好您的验证码，不要告诉别人！并且请在五分钟之内使用" +
                "<!--<br/><span style='color:green;font-size:24px;'>测试专用,请勿回复</span>--></p>" +
                "<p style='line-height:60px;'>来自：<span style='color:green;'>" +fromMail+
                "</span></p>";
        messageHelper.setSubject("Premium注册");
        messageHelper.setText(content,true);
        messageHelper.setFrom(fromMail);
        messageHelper.setTo(toMail);
        if(mailSender!=null){
            mailSender.send(mimeMessage);
            System.out.println("successful");
        }else{
            System.out.println("空");
        }
    }
}
