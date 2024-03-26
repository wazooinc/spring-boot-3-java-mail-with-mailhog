package com.example.springboot3javamailwithmailhog.controllers;

import com.example.springboot3javamailwithmailhog.services.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/emails")
public class EmailController {

  final EmailService emailService;

  @PostMapping("/text")
  @ResponseStatus(HttpStatus.OK)
  public void sendText() throws MessagingException {
    emailService.sendMessage("text subject line", "this is a text message body", false);
  }

  @PostMapping("/html")
  @ResponseStatus(HttpStatus.OK)
  public void sendHtml() throws MessagingException {
    emailService.sendMessage("html subject line", "this is a <b>html</b> <h1>message body</h1>", true);
  }
  
}
