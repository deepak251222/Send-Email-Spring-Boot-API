package com.mail.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mail.service.EmailService;
@RestController
@RequestMapping("/mail")
public class EmailSendController {
	
    private EmailService emailService;

    public EmailSendController(com.mail.service.EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
        return emailService.sendMail(file, to, cc, subject, body);
    }

}
