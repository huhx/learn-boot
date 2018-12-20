package com.linux.huhx.controller;

import com.linux.huhx.model.KafkaMessage;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/kafka")
public class KafkaProducerController {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @PostMapping()
  public String postKafkaMessage(@RequestBody KafkaMessage kafkaMessage)
      throws ExecutionException, InterruptedException {
    ListenableFuture<SendResult<String, String>> resultListenableFuture = kafkaTemplate
        .send(kafkaMessage.getTopic(), kafkaMessage.getMessage());
    SendResult<String, String> stringStringSendResult = resultListenableFuture.get();
    return stringStringSendResult.getProducerRecord().toString();
  }
}
