package vn.com.ltdt.finwise.services;

import org.thymeleaf.context.Context;

public interface MailService {
    void sendMail(String to, String subject, String templateName, Context context);
}
