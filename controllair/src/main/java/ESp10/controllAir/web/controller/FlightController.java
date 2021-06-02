package ESp10.controllAir.web.controller;

import ESp10.controllAir.services.FlightService;
import ESp10.controllAir.services.models.Flight;
import ESp10.controllAir.web.dto.FlightDto;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FlightController {
  @Autowired private FlightService flightService;

  @GetMapping(path = "/arrivals")
  @ResponseStatus(HttpStatus.OK)
  public Collection<FlightDto> getLastArrivalFlights() {
    Collection<Flight> lastlights = flightService.getLastArrivalFlights();
    // mapear para FlightDTO
    Collection<FlightDto> flightDtos = new ArrayList<>();
    for (Flight flight : lastlights) {
      FlightDto flightDto = mapFromFlightToFlightDto(flight);
      flightDtos.add(flightDto);
    }
    return flightDtos;
  }

  @CrossOrigin(origins = "http://localhost:3000") // localhost -> ip ?
  @GetMapping(path = "/departures")
  @ResponseStatus(HttpStatus.OK)
  public Collection<FlightDto> getLastDepartureFlights() {
    Collection<Flight> lastlights = flightService.getLastDepartureFlights();
    // mapear para FlightDTO
    Collection<FlightDto> flightDtos = new ArrayList<>();
    for (Flight flight : lastlights) {
      FlightDto flightDto = mapFromFlightToFlightDto(flight);
      flightDtos.add(flightDto);
    }
    return flightDtos;
  }

  @CrossOrigin(origins = "http://localhost:3000") // localhost -> ip ?
  @GetMapping(path = "/history")
  @ResponseStatus(HttpStatus.OK)
  public Collection<FlightDto> getLast7DFlights() { // from db
    Collection<Flight> last24HoursFlights = flightService.getFlightsFromDb();
    // mapear para FlightDTO
    Collection<FlightDto> flightDtos = new ArrayList<>();
    for (Flight flight : last24HoursFlights) {
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
    // TODO fazer os metodos restantes para todos os atributos
    return flightDto;
  }
}
