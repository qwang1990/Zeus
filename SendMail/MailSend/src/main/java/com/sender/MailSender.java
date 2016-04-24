package com.sender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * Created by wangqi on 16/4/20.
 */
public class MailSender {

    private final static String USERNAME = "auto_server@yimei180.com";
    private final static String PASSWORD = "Aa1234567890";
    protected static JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

    public static void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        //设置发送邮件服务信息
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername(USERNAME);
        javaMailSender.setPassword(PASSWORD);
        javaMailSender.setJavaMailProperties(new Properties() {{
            put("mail.transport.protocol", "smtp");
            put("mail.smtp.auth", true);
            put("mail.smtp.starttls.enable", true);
            put("mail.debug", true);
        }});
        msg.setFrom(USERNAME);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(content);
        try {
            javaMailSender.send(msg);
           // logger().info(logPrint(to,"验证码邮件",content));
        } catch (Exception x) {
            //logger().error("邮件发送失败：", x);
        }
    }

    /**
     * 输入依次为目的邮箱,主题,内容
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("请输入正确参数(主题,内容,目的邮箱1)");
        }

        for(int i = 2;i<args.length;i++) {
            MailSender.sendSimpleMail(args[i],args[0],args[1]);
        }
    }
}
