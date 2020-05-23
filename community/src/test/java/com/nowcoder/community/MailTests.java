package com.nowcoder.community;

import com.nowcoder.community.dto.MailDto;
import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTestMail(){
        MailDto mailDto = new MailDto();
        mailDto.setTo("463147064@qq.com");
        mailDto.setSubject("Test");
        mailDto.setContent("Welcome");
        mailClient.sendMail(mailDto);
    }

    @Test
    public void sendSimpleMail(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("463147064@qq.com");
        message.setTo("463147064@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    @Test
    public void testHtmlMail(){
        MailDto mailDto = new MailDto();
        Context context = new Context();
        context.setVariable("username","sunday");
        String content = templateEngine.process("mail/demo",context);
        System.out.println(content);
        mailDto.setTo("463147064@qq.com");
        mailDto.setSubject("Html");
        mailDto.setContent(content);
        mailClient.sendMail(mailDto);
    }
}
