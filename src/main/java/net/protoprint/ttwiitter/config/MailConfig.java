package net.protoprint.ttwiitter.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${sping.mail.host}")
    private String host;

    @Value("${sping.mail.username}")
    private String username;

    @Value("${sping.mail.password}")
    private String password;

    @Value("${sping.mail.port}")
    private int port;

    @Value("${sping.mail.protocol}")
    private String protocol;

    @Value("${mail.debug}")
    private String debug;
    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);
        properties.setProperty("mail.smtp.ssl.enable", "true");


        return mailSender;
    }
}
