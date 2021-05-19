package pt.ua.es.sky_traffic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
  private String openSkyUri;

  public String getOpenSkyUri() {
    return openSkyUri;
  }

  public void setOpenSkyUri(String openSkyUri) {
    this.openSkyUri = openSkyUri;
  }
}
