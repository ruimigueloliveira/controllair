package ESp10.controllAir.data.external;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ESp10.controllAir.services.FlightService;
import ESp10.controllAir.web.controller.FlightController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FlightController.class)
public class WebMockTest {
  private final Logger logger = LoggerFactory.getLogger(WebMockTest.class);

  @Autowired private MockMvc mockMvc;

  @MockBean private FlightService service;

  @Test
  public void greetingShouldReturnMessageFromService() throws Exception {
    this.mockMvc.perform(get("/api/arrivals")).andDo(print()).andExpect(status().isOk());
    logger.info("status ok!");
  }
}
