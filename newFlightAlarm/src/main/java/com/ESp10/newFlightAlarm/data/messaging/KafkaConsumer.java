package com.ESp10.newFlightAlarm.data.messaging;



import com.ESp10.newFlightAlarm.services.models.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class KafkaConsumer {

  private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "flights", groupId = "group_id")
  public void consume(Collection<Flight> message) throws IOException {
    logger.info(String.valueOf(message));


  }
}
