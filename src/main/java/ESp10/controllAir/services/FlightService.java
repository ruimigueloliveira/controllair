package ESp10.controllAir.services;

import ESp10.controllAir.config.AppConfig;
import ESp10.controllAir.external.OpenSkyClient;
import ESp10.controllAir.external.OpenSkyDto;
import ESp10.controllAir.services.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class FlightService {
  @Autowired private OpenSkyClient openSkyClient;
  @Autowired private AppConfig appConfig;

  public Collection<Flight> getLastArrivalFlights() {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getArrivalFlights(
            appConfig.getAirportCode(), LocalDateTime.now().minusDays(3), LocalDateTime.now());
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    return flights;

    // return
    // openSkyDtos.stream().map(this::mapFromOpenSkyDtoToFlight).collect(Collectors.toList());
  }

  public Collection<Flight> getLastDepartureFlights() {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getDepartureFlights(
            appConfig.getAirportCode(), LocalDateTime.now().minusDays(3), LocalDateTime.now());
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
