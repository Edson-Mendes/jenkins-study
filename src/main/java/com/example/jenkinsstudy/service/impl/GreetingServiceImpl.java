package com.example.jenkinsstudy.service.impl;

import com.example.jenkinsstudy.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String getGreeting(String name) {
    String greetingTemplate = "Hello %s!";
    String value = name != null ? name : "World";

    return greetingTemplate.formatted(value);
  }

}
