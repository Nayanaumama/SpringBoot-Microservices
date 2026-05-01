package com.example.javamailsender.service;

import org.springframework.web.multipart.MultipartFile;


public interface EmailService {

    //sending mail to single user
    void sendEmail(String to, String subject, String message);
    //sending email to multiple user
    void sendEmail(String[] to, String subject, String message);
    //sending Email with html
    void sendEmailWithHtml(String to, String subject, String htmlMessage);
    //sending Email with file
    void sendEmailWithAttachment(String to, String subject, String htmlmessage, MultipartFile filePath);
}
