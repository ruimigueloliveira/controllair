package pt.ua.es.sky_traffic.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.es.sky_traffic.config.AppConfig;
import pt.ua.es.sky_traffic.data.external.OpenSkyClient;
import pt.ua.es.sky_traffic.data.external.OpenSkyDto;
import pt.ua.es.sky_traffic.services.models.Flight;

@Service
public class FlightService {
  @Autowired private OpenSkyClient openSkyClient;
  @Autowired private AppConfig appConfig;

  public Collection<Flight> getLastFlights() {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getFlights(
            LocalDateTime.now().minusDays(10).minusHours(10),
            LocalDateTime.now().minusDays(10).minusHours(9).minusMinutes(30));
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    return flights;

    // return
    // openSkyDtos.stream().map(this::mapFromOpenSkyDtoToFlight).collect(Collectors.toList());
  }

  private Flight mapFromOpenSkyDtoToFlight(OpenSkyDto openSkyDto) {
    Flight flight = new Flight();
    flight.setCallsign(openSkyDto.getCallsign());
    flight.setIcao24(openSkyDto.getIcao24());
    flight.setLastSeen(
        LocalDateTime.ofInstant(
            Instant.ofEpochSecond(openSkyDto.getLastSeen()), ZoneId.systemDefault()));
    flight.setFirstSeen(
        LocalDateTime.ofInstant(
            Instant.ofEpochSecond(openSkyDto.getFirstSeen()), ZoneId.systemDefault()));
    flight.setEstArrivalAirport(openSkyDto.getEstArrivalAirport());
    flight.setEstDepartureAirport(openSkyDto.getEstDepartureAirport());
    flight.setEstDepartureAirportHorizDistance(openSkyDto.getEstDepartureAirportHorizDistance());
    flight.setEstDepartureAirportVertDistance(openSkyDto.getEstDepartureAirportVertDistance());
    flight.setEstArrivalAirportHorizDistance(openSkyDto.getEstArrivalAirportHorizDistance());
    flight.setEstArrivalAirportVertDistance(openSkyDto.getEstArrivalAirportVertDistance());
    flight.setDepartureAirportCandidatesCount(openSkyDto.getDepartureAirportCandidatesCount());
    flight.setArrivalAirportCandidatesCount(openSkyDto.getArrivalAirportCandidatesCount());
    // MAPEAR PARA OS RESTANTES ATRIBUTOS
    return flight;
  }
}
