package pt.ua.es.sky_traffic.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.ua.es.sky_traffic.services.FlightService;
import pt.ua.es.sky_traffic.services.models.Flight;
import pt.ua.es.sky_traffic.web.dto.FlightDto;

@RestController
@RequestMapping("/api")
public class FlightController {
  @Autowired private FlightService flightService;

  @GetMapping(path = "/flights")
  @ResponseStatus(HttpStatus.OK)
  public Collection<FlightDto> getLastFlights() {
    Collection<Flight> lastlights = flightService.getLastFlights();
    // mapear para FlightDTO
    Collection<FlightDto> flightDtos = new ArrayList<>();
    for (Flight flight : lastlights) {
      FlightDto flightDto = mapFromFlightToFlightDto(flight);
      flightDtos.add(flightDto);
    }
    return flightDtos;
  }

  private FlightDto mapFromFlightToFlightDto(Flight flight) {
    FlightDto flightDto = new FlightDto();
    flightDto.setIcao24(flight.getIcao24());
    flightDto.setFirstSeen(flight.getFirstSeen());
    flightDto.setEstDepartureAirport(flight.getEstDepartureAirport());
    flightDto.setLastSeen(flight.getLastSeen());
    flightDto.setEstArrivalAirport(flight.getEstArrivalAirport());
    flightDto.setCallsign(flight.getCallsign());
    flightDto.setEstDepartureAirportHorizDistance(flight.getEstDepartureAirportHorizDistance());
    flightDto.setEstDepartureAirportVertDistance(flight.getEstDepartureAirportVertDistance());
    flightDto.setEstArrivalAirportHorizDistance(flight.getEstArrivalAirportHorizDistance());
    flightDto.setEstArrivalAirportVertDistance(flight.getEstArrivalAirportVertDistance());
    flightDto.setDepartureAirportCandidatesCount(flight.getDepartureAirportCandidatesCount());
    flightDto.setArrivalAirportCandidatesCount(flight.getArrivalAirportCandidatesCount());

    flightDto.setEstArrivalAirport(flight.getEstArrivalAirport());
    // fazer os metodos restantes para todos os atributos
    return flightDto;
  }
}
