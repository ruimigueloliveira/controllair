package ESp10.controllAir.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class FlightDto {

  private String icao24;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime firstSeen;

  private String estDepartureAirport;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime lastSeen;

  private String estArrivalAirport;
  private String callsign;
  private Integer estDepartureAirportHorizDistance;
  private Integer estDepartureAirportVertDistance;
  private Integer estArrivalAirportHorizDistance;
  private Integer estArrivalAirportVertDistance;
  private Integer departureAirportCandidatesCount;
  private Integer arrivalAirportCandidatesCount;

  public FlightDto() {}

  public FlightDto(
      String icao24,
      LocalDateTime firstSeen,
      String estDepartureAirport,
      LocalDateTime lastSeen,
      String estArrivalAirport,
      String callsign,
      Integer estDepartureAirportHorizDistance,
      Integer estDepartureAirportVertDistance,
      Integer estArrivalAirportHorizDistance,
      Integer estArrivalAirportVertDistance,
      Integer departureAirportCandidatesCount,
      Integer arrivalAirportCandidatesCount) {
    this.icao24 = icao24;
    this.firstSeen = firstSeen;
    this.estDepartureAirport = estDepartureAirport;
    this.lastSeen = lastSeen;
    this.estArrivalAirport = estArrivalAirport;
    this.callsign = callsign;
    this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
  }

  public String getIcao24() {
    return icao24;
  }

  public void setIcao24(String icao24) {
    this.icao24 = icao24;
  }

  public LocalDateTime getFirstSeen() {
    return firstSeen;
  }

  public void setFirstSeen(LocalDateTime firstSeen) {
    this.firstSeen = firstSeen;
  }

  public String getEstDepartureAirport() {
    return estDepartureAirport;
  }

  public void setEstDepartureAirport(String estDepartureAirport) {
    this.estDepartureAirport = estDepartureAirport;
  }

  public LocalDateTime getLastSeen() {
    return lastSeen;
  }

  public void setLastSeen(LocalDateTime lastSeen) {
    this.lastSeen = lastSeen;
  }

  public String getEstArrivalAirport() {
    return estArrivalAirport;
  }

  public void setEstArrivalAirport(String estArrivalAirport) {
    this.estArrivalAirport = estArrivalAirport;
  }

  public String getCallsign() {
    return callsign;
  }

  public void setCallsign(String callsign) {
    this.callsign = callsign;
  }

  public Integer getEstDepartureAirportHorizDistance() {
    return estDepartureAirportHorizDistance;
  }

  public void setEstDepartureAirportHorizDistance(Integer estDepartureAirportHorizDistance) {
    this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
  }

  public Integer getEstDepartureAirportVertDistance() {
    return estDepartureAirportVertDistance;
  }

  public void setEstDepartureAirportVertDistance(Integer estDepartureAirportVertDistance) {
    this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
  }

  public Integer getEstArrivalAirportHorizDistance() {
    return estArrivalAirportHorizDistance;
  }

  public void setEstArrivalAirportHorizDistance(Integer estArrivalAirportHorizDistance) {
    this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
  }

  public Integer getEstArrivalAirportVertDistance() {
    return estArrivalAirportVertDistance;
  }

  public void setEstArrivalAirportVertDistance(Integer estArrivalAirportVertDistance) {
    this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
  }

  public Integer getDepartureAirportCandidatesCount() {
    return departureAirportCandidatesCount;
  }

  public void setDepartureAirportCandidatesCount(Integer departureAirportCandidatesCount) {
    this.departureAirportCandidatesCount = departureAirportCandidatesCount;
  }

  public Integer getArrivalAirportCandidatesCount() {
    return arrivalAirportCandidatesCount;
  }

  public void setArrivalAirportCandidatesCount(Integer arrivalAirportCandidatesCount) {
    this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
  }

  @Override
  public String toString() {
    return "FlightDto{"
        + "icao24='"
        + icao24
        + '\''
        + ", firstSeen="
        + firstSeen
        + ", estDepartureAirport='"
        + estDepartureAirport
        + '\''
        + ", lastSeen="
        + lastSeen
        + ", estArrivalAirport='"
        + estArrivalAirport
        + '\''
        + ", callsign='"
        + callsign
        + '\''
        + ", estDepartureAirportHorizDistance="
        + estDepartureAirportHorizDistance
        + ", estDepartureAirportVertDistance="
        + estDepartureAirportVertDistance
        + ", estArrivalAirportHorizDistance="
        + estArrivalAirportHorizDistance
        + ", estArrivalAirportVertDistance="
        + estArrivalAirportVertDistance
        + ", departureAirportCandidatesCount="
        + departureAirportCandidatesCount
        + ", arrivalAirportCandidatesCount="
        + arrivalAirportCandidatesCount
        + '}';
  }
}
