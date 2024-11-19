package com.example.Alpha_telekom.integrations;


import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class MailConfig {

    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.smtp.port}")
    private int port;

    @Value("${mail.smtp.auth}")
    private boolean auth;

    @Value("${mail.smtp.starttls.enable}")
    private boolean starttls;

    @Value("${mail.sender.email}")
    private String senderEmail;

    @Value("${mail.sender.password}")
    private String senderPassword;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isAuth() {
        return auth;
    }

    public boolean isStarttls() {
        return starttls;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSenderPassword() {
        return senderPassword;
    }
}
