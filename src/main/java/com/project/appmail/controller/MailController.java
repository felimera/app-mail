package com.project.appmail.controller;

import com.project.appmail.model.dto.MailStructureDTO;
import com.project.appmail.service.MailService;
import com.project.appmail.service.mapper.MailStructureMapper;
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
    public ResponseEntity<String> sendMail(@PathVariable(name = "mail") String mail, @RequestBody MailStructureDTO mailStructureDTO) {
        mailService.sendMail(mail, MailStructureMapper.INSTANCE.fromDomainModel(mailStructureDTO));
        return ResponseEntity.ok("Successfully sent the mail!!");
    }
}
