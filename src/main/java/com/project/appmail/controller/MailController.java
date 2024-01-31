package com.project.appmail.controller;

import com.project.appmail.model.MailStructure;
import com.project.appmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/mail")
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping(path = "/send/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable(name = "mail") String mail, @RequestBody MailStructure mailStructure) {
        mailService.sendMail(mail, mailStructure);
        return ResponseEntity.ok("Successfully sent the mail!!");
    }
}
