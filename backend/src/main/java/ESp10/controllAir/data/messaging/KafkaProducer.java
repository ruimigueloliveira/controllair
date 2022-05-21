package ESp10.controllAir.data.messaging;

import ESp10.controllAir.services.models.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {
  private static final String TOPIC = "flights";
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  @Autowired private KafkaTemplate<String, Flight> kafkaTemplate;

  public void sendMessage(String key, Flight message) {
    kafkaTemplate
        .send(TOPIC, key, message)
        .addCallback(
            new ListenableFutureCallback<SendResult<String, Flight>>() {
              @Override
              public void onFailure(Throwable ex) {
                log.error("Flight: {} failed to be sent to kafka", message.toString(), ex);
              }

              @Override
              public void onSuccess(SendResult<String, Flight> result) {
                log.info(
                    "Flight: {}  Flight was sent to kafka with offset: id--> {}",
                    message.getIcao24(),
                    result.getRecordMetadata().offset());
              }
            });
  }
}
