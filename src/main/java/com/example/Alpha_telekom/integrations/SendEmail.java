package com.example.Alpha_telekom.integrations;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendEmail {

    private final MailConfig mailConfig;

    public SendEmail(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    public  void sendEmail(String recipient, String title, String body) {


        // Настройки SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailConfig.isAuth());
        props.put("mail.smtp.starttls.enable", mailConfig.isStarttls());
        props.put("mail.smtp.host", mailConfig.getHost());
        props.put("mail.smtp.port", mailConfig.getPort());// TLS

        // Создание сессии

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailConfig.getSenderEmail(), mailConfig.getSenderPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailConfig.getSenderEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(title);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
