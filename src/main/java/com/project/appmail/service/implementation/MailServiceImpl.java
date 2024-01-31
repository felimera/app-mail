package com.project.appmail.service.implementation;

import com.project.appmail.model.MailStructure;
import com.project.appmail.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

@Service
public class MailServiceImpl implements MailService {
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendMail(String mail, MailStructure mailStructure) {

        Context context = new Context();
        context.setVariable("nameOwner", "User's full name");
        String htmlContext = templateEngine.process("index", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = null;
        try {
            message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            message.setTo(mail);
            message.setFrom(fromMail);
            message.setSubject(mailStructure.getSubject());
            message.setSentDate(new Date());
            message.setText(htmlContext, true);

            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
