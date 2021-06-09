package ESp10.controllAir.data.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  // public void flightSouldReturnDefaultMessage() {
  //   assertThat(
  //       this.restTemplate.getForObject(
  //           "http://localhost:" + port + "/api/arrivals", OpenSkyDto[].class));
  // }
}
