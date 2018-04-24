package com.gree.springboot.maildemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailUtil {
    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    @Autowired
    private JavaMailSender mailSender;

//    @Autowired
//    private TemplateEngine templateEngine;

    public void sendSimpleMail(String deliver,String[] receiver,String[] carbonCopy,String subject,String content) {
        long startTimeStamp = System.nanoTime();
        logger.info("Start send mail");
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(deliver);
            message.setTo(receiver);
            message.setCc(carbonCopy);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            logger.info("Send mail success,cost{} million Seconds",System.nanoTime() - startTimeStamp);
        }catch (Exception e) {
            logger.error("Send mail failed,error message is {} \n",e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }


    }

    public void sendHTMLEmail(String deliver,String[] receiver,String[] carbonCopy,String subject,String content,boolean isHtml) {
        long startTimestamp = System.currentTimeMillis();
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,isHtml);
            mailSender.send(message);
            logger.info("Send mail success,cost{} million Seconds",System.currentTimeMillis() - startTimestamp);

        } catch (Exception e) {
            logger.error("Send mail failed,error message is {} \n",e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public void sendAttachmentMail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, String filename, File file) {
        long startTimestamp = System.currentTimeMillis();
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            messageHelper.addAttachment(filename,file);
            mailSender.send(message);
            logger.info("send email success,cost {} million Seconds",System.currentTimeMillis() - startTimestamp);
        } catch (Exception e) {
            logger.error("Send email failed,error message is {} \n",e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
