package com.example.kafka;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

//  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  /*@KafkaListener(topics = "${kakfa.topic.json}" ,groupId = "json",containerFactory = "kafkaListenerContainerFactory")*/
  @KafkaListener(topics = "${kakfa.topic.json}")
  public void receive(UserModel userModel) {
//    LOGGER.info("received car='{}'", car.toString());
    latch.countDown();

    System.out.println("consumed message --"+userModel);
  }
}