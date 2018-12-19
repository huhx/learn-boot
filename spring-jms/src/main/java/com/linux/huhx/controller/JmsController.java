package com.linux.huhx.controller;

import com.linux.huhx.model.UserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/jms")
public class JmsController {

  @Autowired
  private JmsTemplate jmsTemplate;

  @GetMapping()
  public String getJms() {
    jmsTemplate.convertAndSend("mailbox", new UserEmail("gohuhx@gmail.com", "HelloWorld"));
    return "Hello World";
  }
}
