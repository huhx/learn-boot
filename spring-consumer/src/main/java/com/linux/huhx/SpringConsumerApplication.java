package com.linux.huhx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringConsumerApplication.class, args);
  }

  @KafkaListener(topics = "test", groupId = "group-id")
  public void listen(String message) {
    System.out.println("Received message in group - group-id: " + message);
  }

}

