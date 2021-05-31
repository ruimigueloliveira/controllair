package ESp10.controllAir.data.persistance.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight") // nao quero q a minha tabela tenha uma coluna chamada flightentity
public class FlightEntity {

  @Column(name = "icao24")
  private String icao24;

  @Column(name = "first_seen")
  private LocalDateTime firstSeen;

  @Column(name = "est_departure_airport")
  private String estDepartureAirport;

  @Id
  @Column(name = "last_seen")
  private LocalDateTime lastSeen;

  @Column(name = "est_arrival_airport")
  private String estArrivalAirport;

  @Column(name = "callsign")
  private String callsign;

  @Column(name = "est_departure_airport_horiz_distance")
  private Integer estDepartureAirportHorizDistance;

  @Column(name = "est_Departure_Airport_Vert_Distance")
  private Integer estDepartureAirportVertDistance;

  @Column(name = "est_Arrival_Airport_Horiz_Distance")
  private Integer estArrivalAirportHorizDistance;

  @Column(name = "est_Arrival_Airport_Vert_Distance")
  private Integer estArrivalAirportVertDistance;

  @Column(name = "departure_Airport_Candidates_Count")
  private Integer departureAirportCandidatesCount;

  @Column(name = "arrival_Airport_Candidates_Count")
  private Integer arrivalAirportCandidatesCount;

  public FlightEntity() {}

  public String getIcao24() {
    return icao24;
  }

  public LocalDateTime getFirstSeen() {
    return firstSeen;
  }

  public String getEstDepartureAirport() {
    return estDepartureAirport;
  }

  public LocalDateTime getLastSeen() {
    return lastSeen;
  }

  public String getEstArrivalAirport() {
    return estArrivalAirport;
  }

  public String getCallsign() {
    return callsign;
  }

  public Integer getEstDepartureAirportHorizDistance() {
    return estDepartureAirportHorizDistance;
  }

  public Integer getEstDepartureAirportVertDistance() {
    return estDepartureAirportVertDistance;
  }

  public Integer getEstArrivalAirportHorizDistance() {
    return estArrivalAirportHorizDistance;
  }

  public Integer getEstArrivalAirportVertDistance() {
    return estArrivalAirportVertDistance;
  }

  public Integer getDepartureAirportCandidatesCount() {
    return departureAirportCandidatesCount;
  }

  public Integer getArrivalAirportCandidatesCount() {
    return arrivalAirportCandidatesCount;
  }

  public void setIcao24(String icao24) {
    this.icao24 = icao24;
  }

  public void setFirstSeen(LocalDateTime firstSeen) {
    this.firstSeen = firstSeen;
  }

  public void setEstDepartureAirport(String estDepartureAirport) {
    this.estDepartureAirport = estDepartureAirport;
  }

  public void setLastSeen(LocalDateTime lastSeen) {
    this.lastSeen = lastSeen;
  }

  public void setEstArrivalAirport(String estArrivalAirport) {
    this.estArrivalAirport = estArrivalAirport;
  }

  public void setCallsign(String callsign) {
    this.callsign = callsign;
  }

  public void setEstDepartureAirportHorizDistance(Integer estDepartureAirportHorizDistance) {
    this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
  }

  public void setEstDepartureAirportVertDistance(Integer estDepartureAirportVertDistance) {
    this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
  }

  public void setEstArrivalAirportHorizDistance(Integer estArrivalAirportHorizDistance) {
    this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
  }

  public void setEstArrivalAirportVertDistance(Integer estArrivalAirportVertDistance) {
    this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
  }

  public void setDepartureAirportCandidatesCount(Integer departureAirportCandidatesCount) {
    this.departureAirportCandidatesCount = departureAirportCandidatesCount;
  }

  public void setArrivalAirportCandidatesCount(Integer arrivalAirportCandidatesCount) {
    this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
  }

  @Override
  public String toString() {
    return "FlightEntity{"
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
