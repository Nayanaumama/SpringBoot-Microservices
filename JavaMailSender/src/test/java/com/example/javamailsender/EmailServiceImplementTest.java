package com.example.javamailsender;


import com.example.javamailsender.impl.EmailServiceImplement;
import com.example.javamailsender.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailServiceImplementTest {

    @Autowired
    EmailService emailService;

    @Test
    public void sendEmailTest()
    {
        emailService.sendEmail("exampleid","Testing the java mail sender","This is a test mail");
    }

    @Test
    public void sendEmailWithHtml()
    {
        emailService.sendEmailWithHtml("exampleid","Testing the java mail sender","<h1><This is a test mail></h1>");
    }
}
