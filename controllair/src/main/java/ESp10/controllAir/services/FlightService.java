package ESp10.controllAir.services;

import static java.time.LocalDateTime.now;

import ESp10.controllAir.config.AppConfig;
import ESp10.controllAir.data.external.OpenSkyClient;
import ESp10.controllAir.data.external.OpenSkyDto;
import ESp10.controllAir.data.persistance.entity.FlightEntity;
import ESp10.controllAir.data.persistance.repository.FlightRepository;
import ESp10.controllAir.services.models.Flight;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
  @Autowired private OpenSkyClient openSkyClient;
  @Autowired private AppConfig appConfig;
  @Autowired private FlightRepository flightRepository;

  public Collection<Flight> getLastArrivalFlights() {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getArrivalFlights(
            appConfig.getAirportCode(), LocalDateTime.now().minusDays(2), LocalDateTime.now());
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    saveFlights(flights);
    return flights;
  }

  public Collection<Flight> getLastDepartureFlights() {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getDepartureFlights(
            appConfig.getAirportCode(), LocalDateTime.now().minusDays(2), LocalDateTime.now());
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    return flights;
  }

  public Collection<Flight> getArrivalFlightsForTimeInterval(
      LocalDateTime start, LocalDateTime end) {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getArrivalFlights(appConfig.getAirportCode(), start, end);
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    saveFlights(flights);
    return flights;
  }

  public Collection<Flight> getDepartureFlightsForTimeInterval(
      LocalDateTime start, LocalDateTime end) {
    Collection<OpenSkyDto> openSkyDtos =
        openSkyClient.getDepartureFlights(appConfig.getAirportCode(), start, end);
    ArrayList<Flight> flights = new ArrayList<>();
    for (OpenSkyDto dto : openSkyDtos) {
      Flight flight = mapFromOpenSkyDtoToFlight(dto);
      flights.add(flight);
    }
    saveFlights(flights);
    return flights;
  }

  public Collection<Flight> getFlightsFromDb() {
    ArrayList<Flight> flights = new ArrayList<>();
    Collection<FlightEntity> flightEntityList =
        flightRepository.findByLastSeenBetween(
            now().minusDays(7), now()); // voos de 7 dias anteriores
    for (FlightEntity entity : flightEntityList) {
      Flight flight = mapFromEntityToModel(entity);
      flights.add(flight);
    }
    return flights;
  }

  private void saveFlights(Collection<Flight> flightsToSave) {

    Collection<FlightEntity> flightEntities = new ArrayList<>();

    for (Flight flight : flightsToSave) {
      FlightEntity f = new FlightEntity();
      f.setCallsign(flight.getCallsign());
      f.setEstArrivalAirport(flight.getEstArrivalAirport());
      f.setLastSeen(flight.getLastSeen());
      f.setFirstSeen(flight.getFirstSeen());
      f.setEstDepartureAirport(flight.getEstDepartureAirport());
      f.setEstArrivalAirport(flight.getEstArrivalAirport());
      f.setIcao24(flight.getIcao24());
      f.setEstDepartureAirportHorizDistance(flight.getEstDepartureAirportHorizDistance());
      f.setEstDepartureAirportVertDistance(flight.getEstDepartureAirportVertDistance());
      f.setEstArrivalAirportHorizDistance(flight.getEstArrivalAirportHorizDistance());
      f.setEstArrivalAirportVertDistance(flight.getEstArrivalAirportVertDistance());
      f.setDepartureAirportCandidatesCount(flight.getDepartureAirportCandidatesCount());
      f.setArrivalAirportCandidatesCount(flight.getArrivalAirportCandidatesCount());
      flightEntities.add(f);
    }

    flightRepository.saveAll(flightEntities);
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

  private Flight mapFromEntityToModel(FlightEntity flightEntity) {
    Flight flight = new Flight();

    flight.setCallsign(flightEntity.getCallsign());
    flight.setIcao24(flightEntity.getIcao24());
    flight.setLastSeen(flightEntity.getLastSeen());
    flight.setFirstSeen(flightEntity.getFirstSeen());
    flight.setEstArrivalAirport(flightEntity.getEstArrivalAirport());
    flight.setEstDepartureAirport(flightEntity.getEstDepartureAirport());
    flight.setEstDepartureAirportHorizDistance(flightEntity.getEstDepartureAirportHorizDistance());
    flight.setEstDepartureAirportVertDistance(flightEntity.getEstDepartureAirportVertDistance());
    flight.setEstArrivalAirportHorizDistance(flightEntity.getEstArrivalAirportHorizDistance());
    flight.setEstArrivalAirportVertDistance(flightEntity.getEstArrivalAirportVertDistance());
    flight.setDepartureAirportCandidatesCount(flightEntity.getDepartureAirportCandidatesCount());
    flight.setArrivalAirportCandidatesCount(flightEntity.getArrivalAirportCandidatesCount());

    return flight;
  }
}
