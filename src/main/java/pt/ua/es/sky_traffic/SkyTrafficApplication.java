package pt.ua.es.sky_traffic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SkyTrafficApplication {

  public static void main(String[] args) {
    SpringApplication.run(SkyTrafficApplication.class, args);
  }
}
