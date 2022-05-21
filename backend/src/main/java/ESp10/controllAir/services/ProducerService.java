package ESp10.controllAir.services;

import static java.time.LocalDateTime.now;

import ESp10.controllAir.data.messaging.KafkaProducer;
import ESp10.controllAir.services.models.Flight;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

  @Autowired KafkaProducer kafkaProducer;
  @Autowired FlightService flightService;

  public void getNewFlights() {

    try {
      final Collection<Flight> newFlights =
          flightService.getArrivalFlightsForTimeInterval(
              now().minusDays(1), now()); // vou por aqui um dia apenas para ver q está a funcionar

      for (Flight flight : newFlights) {
        kafkaProducer.sendMessage(flight.getEstArrivalAirport(), flight);
      }

    } catch (Exception e) {
      Logger logger = LoggerFactory.getLogger(ProducerService.class);
      logger.info("Não chegou nenhum voo ao Aeroporto nos ultimos 5 minutos");
    }
  }
}
