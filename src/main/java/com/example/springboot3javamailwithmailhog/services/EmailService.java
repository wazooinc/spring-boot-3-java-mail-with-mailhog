package com.example.springboot3javamailwithmailhog.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

  @Value("${notification.host_name}")
  String hostName;

  @Value("${notification.host_port}")
  String hostPort;

  public void sendMessage(String subject, String message, Boolean isHtml) throws MessagingException {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(hostName);
    mailSender.setPort(Integer.valueOf(hostPort));
    mailSender.setUsername("");
    mailSender.setPassword("");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");

    MimeMessage mimeMessage = mailSender.createMimeMessage();

    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
    mimeMessageHelper.setFrom("springboot@home.com");
    mimeMessageHelper.setText(message, isHtml);
    mimeMessageHelper.setTo("admin@test.com");
    mimeMessageHelper.setSubject(subject);

    mailSender.send(mimeMessage);
  }
  
}
