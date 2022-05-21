package ESp10.controllAir;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ESp10.controllAir.config.AppConfig;
import ESp10.controllAir.services.FlightService;
import ESp10.controllAir.web.controller.FlightController;
import ESp10.controllAir.web.controller.KafkaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ControllAirApplicationTests {

  @Autowired private FlightController controller;
  @Autowired private AppConfig appConfig;

  //@Autowired KafkaConsumer consumer = new KafkaConsumer();
  @Autowired private KafkaController kafkaController;

  @MockBean private FlightService service;

  @Autowired private MockMvc mockMvc;

  @Test
  void contextLoads() throws Exception {
    System.out.println("FlightController & KafkaController exists");
    assertNotNull(controller);
    assertNotNull(kafkaController);
  }

  @Test
  public void requestDepartures() throws Exception {
    System.out.println("Request api");
    this.mockMvc.perform(get("/api/departures")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void requestArrivals() throws Exception {
    System.out.println("Request arrivals");
    this.mockMvc.perform(get("/api/arrivals")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void requestHistory() throws Exception {
    System.out.println("Request arrivals");
    this.mockMvc.perform(get("/api/history")).andDo(print()).andExpect(status().isOk());
  }

  // kafka ones

  /*@Test
  void verify_get_messages() {
    assert (consumer.getTopic() != null && consumer.getTopic() == "flights");
  }

  @Test
  void verify_group() {
    assert (consumer.getgroup() != null && consumer.getgroup() == "group_id");
  }

   */

  @Test
  void verify_uri() {
    System.out.println("arrivals url ok!");
    assert (appConfig
        .getOpenSkyUri()
        .equals("https://USERNAME:PASSWORD@opensky-network.org/api/flights/arrival"));
  }

  @Test
  void verify_uri1() {
    System.out.println("departures url ok!");
    assert (appConfig
        .getOpenSkyUri1()
        .equals("https://USERNAME:PASSWORD@opensky-network.org/api/flights/departure"));
  }

  @Test
  void checkIf_LisbonAirport() {
    System.out.println("departures url ok!");
    assert (appConfig.getAirportCode().equals("LPPT"));
  }
}
