package ESp10.controllAir.data.external;

import static org.assertj.core.api.Assertions.assertThat;

import ESp10.controllAir.web.controller.FlightController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

  @Autowired private FlightController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }
}
