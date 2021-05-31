package ESp10.controllAir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ControllAirApplication {

  public static void main(String[] args) {
    SpringApplication.run(ControllAirApplication.class, args);
  }
}
