package com.example.jenkinsstudy.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomBean {

  @Bean
  public Random getRandom() {
    return new Random();
  }

}
