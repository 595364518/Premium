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
    /**
     * 发送邮件
     * @param mailSender 邮件发送助手
     * @param fromMail 发件人
     * @param toMail 收件人
     * @param validateCode 验证码
     * @param username 注册时的用户名
     * @throws MessagingException 发送失败时将抛出异常
     */
    public void sendEmail(JavaMailSenderImpl mailSender,String fromMail,String toMail,String validateCode,String username)throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        String content =
                "<p style='text-indent:2em;line-height:60px;'>" +
                "尊敬的<span style='color:aqua;font-size:24px;'>" +username+"</span>"+
                "您好!</p>" +
                "<p style='line-height:60px;'>" +
                "您的验证码为：<span style='color:red;font-size:24px;'>" +validateCode+
                "</span>,请保管好您的验证码，打死也不要告诉别人！五分钟之后将失效，请在五分钟之内使用。" +
                "<!--<br/><span style='color:green;font-size:24px;'>测试专用,请勿回复</span>--></p>" +
                "<p style='line-height:60px;'>来自：<span style='color:green;'>" +fromMail+
                "</span></p>";
        messageHelper.setSubject("xxx注册");
		//第二个参数设置是否启用HTML格式
        messageHelper.setText(content,true);
        messageHelper.setFrom(fromMail);
        messageHelper.setTo(toMail);
        if(mailSender!=null){
            mailSender.send(mimeMessage);
            //System.out.println("successful");
        }else{
            //System.out.println("空");
        }
    }
}
