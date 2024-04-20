package com.example.jenkinsstudy.integration.endpoint;

import org.assertj.core.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("Integration tests for endpoint /random/**")
class RandomEndpointIT {

  @Autowired
  private MockMvc mockMvc;

  private final String RANDOM_NUMBER_URI = "/random/number";

  @Test
  @DisplayName("GET /random/number must return status 200 when do not send query params origin and bound")
  void getRandomNumber_MustReturnStatus200_WhenGetSuccessfully() throws Exception {
    mockMvc.perform(get(RANDOM_NUMBER_URI)).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("GET /random/number must return integer between -2147483648 and 2147483647 when do not send query params origin and bound")
  void getRandomNumber_MustReturnAIntegerBetweenMAX_VALUEAndMIN_VALUE_WhenGetSuccessfully() throws Exception {
    mockMvc.perform(get(RANDOM_NUMBER_URI)).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("GET /random/number must return status 400 when origin is bigger than bound")
  void getRandomNumber_MustReturnStatus400_WhenOriginIsBiggerThanBound() throws Exception {
    String origin = "10";
    String bound = "9";

    Assumptions.assumeThat(Integer.valueOf(origin)).isGreaterThanOrEqualTo(Integer.valueOf(bound));

    mockMvc.perform(get(RANDOM_NUMBER_URI)
            .param("origin", origin)
            .param("bound", bound))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

}
