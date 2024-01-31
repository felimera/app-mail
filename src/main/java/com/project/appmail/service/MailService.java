package com.project.appmail.service;

import com.project.appmail.model.MailStructure;

public interface MailService {
    void sendMail(String mail, MailStructure mailStructure);
}
