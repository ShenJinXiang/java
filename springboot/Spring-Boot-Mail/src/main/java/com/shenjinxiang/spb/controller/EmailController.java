package com.shenjinxiang.spb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/22 16:02
 */
@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String username;

    @GetMapping("/simpleMail")
    public String simpleMail() {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(username);
            mailMessage.setTo("111@qq.com");
            mailMessage.setSubject("simpleMail from me");
            mailMessage.setText("使用Spring Boot发送简单邮件。");
            javaMailSender.send(mailMessage);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败: " + e.getMessage();
        }
    }
}
