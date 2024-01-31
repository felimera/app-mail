package com.project.appmail.service.implementation;

import com.project.appmail.model.MailStructure;
import com.project.appmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl  implements MailService {
private JavaMailSender javaMailSender;

@Value("${spring.mail.username}")
private String fromMail;

@Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
@Override
    public  void sendMail(String mail, MailStructure mailStructure)
    {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getMessage());

        simpleMailMessage.setTo(mail);

        javaMailSender.send(simpleMailMessage);
    }
}
