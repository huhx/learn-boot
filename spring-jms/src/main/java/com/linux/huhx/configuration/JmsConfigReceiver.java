package com.linux.huhx.configuration;

import com.linux.huhx.model.UserEmail;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.isEmpty;

@Component
public class JmsConfigReceiver {

  @JmsListener(destination = "mailbox", containerFactory = "myFactory")
  public void receiveMessage(UserEmail userEmail) {
    System.out.println("Received <" + userEmail + ">");
    List<String> list = new ArrayList<>();
    isEmpty("he");
  }
}
