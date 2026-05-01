package com.example.javamailsender.impl;

import com.example.javamailsender.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

@Service
public class EmailServiceImplement implements EmailService {

    JavaMailSender javaMailSender;
    public EmailServiceImplement(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    private Logger logger=Logger.getLogger(EmailServiceImplement.class.getName());
    @Override
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("nayanaumamaheshwar@gmail.com");
        javaMailSender.send(simpleMailMessage);
        logger.info("Email sent successfully");

    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("nayanaumamaheshwar@gmail.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlMessage) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("nayanaumamaheshwar@gmail.com");
            mimeMessageHelper.setText(htmlMessage,true);
            javaMailSender.send(mimeMessage);
            logger.info("Email sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendEmailWithAttachment(String to, String subject, String htmlmessage, MultipartFile filePath) {
MimeMessage message1=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message1, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(htmlmessage);
            mimeMessageHelper.addAttachment(filePath.getOriginalFilename(),filePath);
            javaMailSender.send(message1);
            logger.info("Email sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
