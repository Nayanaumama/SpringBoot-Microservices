package com.example.javamailsender.controller;

import com.example.javamailsender.Entity.CustomResponse;
import com.example.javamailsender.Entity.EmailModel;
import com.example.javamailsender.service.EmailService;
import jakarta.mail.Multipart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
        @PostMapping("/send")
        ResponseEntity<?> sendEmailswithHtml(@RequestBody EmailModel emailModel)
        {
            emailService.sendEmailWithHtml(emailModel.getTo(),emailModel.getSubject(),emailModel.getHtmlmessage());
            return ResponseEntity.ok(CustomResponse.builder().message("EmailSent succesfully").status("success").build());
    }

    @PostMapping("/sendWithFile")
    ResponseEntity<?> sendEmailWithAttachment(@RequestParam String to,
                                              @RequestParam String subject,
                                              @RequestParam String htmlmessage,
                                              @RequestParam MultipartFile file)
    {
        emailService.sendEmailWithAttachment(to,subject,htmlmessage,file);
        return ResponseEntity.ok(CustomResponse.builder().message("EmailSent succesfully").status("success").build());
    }



}
