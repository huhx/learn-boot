package com.linux.huhx.component;

import com.linux.huhx.model.UserEmail;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {

  @JmsListener(destination = "mailbox", containerFactory = "myFactory")
  public void receiveMessage(UserEmail userEmail) {
    System.out.println("Received <" + userEmail + ">");
  }

}
