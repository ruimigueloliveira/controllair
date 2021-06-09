package ESp10.controllAir.data.messaging;

import ESp10.controllAir.services.models.Flight;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

  public String getTopic() {
    return "flights";
  }

  public String getgroup() {
    return "group_id";
  }

  @KafkaListener(topics = "flights", groupId = "group_id")
  public void consume(Flight message) throws IOException {
    logger.info(
        String.format(
            "#### -> Consumed Flight -> id: %s, AirplaneId: %s, Previously Airport: %s, Last Seen: %s",
            message.getIcao24(),
            message.getCallsign(),
            message.getEstDepartureAirport(),
            message.getLastSeen()));
    logger.info("Airport ID--> " + message.getEstArrivalAirport());
  }
}
