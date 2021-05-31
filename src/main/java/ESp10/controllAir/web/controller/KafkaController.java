package ESp10.controllAir.web.controller;

import ESp10.controllAir.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
  private final ProducerService producerService;

  @Autowired
  KafkaController(ProducerService producerService) {
    this.producerService = producerService;
  }

  @Scheduled(fixedRate = 10000) // minuto a minuto (ms)
  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic() {
    this.producerService.getNewFlights();
  }
}
