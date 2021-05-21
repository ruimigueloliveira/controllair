package pt.ua.es.sky_traffic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
  private String openSkyUri;
  private String airportCode;
  private String openSkyUri1;

  public String getAirportCode() {
    return airportCode;
  }

  public void setAirportCode(String airportCode) {
    this.airportCode = airportCode;
  }

  public String getOpenSkyUri() {
    return openSkyUri;
  }

  public void setOpenSkyUri(String openSkyUri) {
    this.openSkyUri = openSkyUri;
  }

  public String getOpenSkyUri1() {
    return openSkyUri1;
  }

  public void setOpenSkyUri1(String openSkyUri1) {
    this.openSkyUri1 = openSkyUri1;
  }
}
