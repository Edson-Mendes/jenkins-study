package com.example.jenkinsstudy.integration.endpoint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("Integration tests for endpoint /greeting/**")
class GreetingEndpointIT {

  private static final String GREETING_URI = "/greeting";
  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("GET /greeting must return status 200 when successfully")
  void getGreeting_MustReturnStatus200_WhenFetchSuccessfully() throws Exception {
    mockMvc.perform(get(GREETING_URI)).andExpect(status().isOk());
  }

}
