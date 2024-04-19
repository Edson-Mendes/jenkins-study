package com.example.jenkinsstudy.service.impl;

import com.example.jenkinsstudy.service.RandomService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomServiceImpl implements RandomService {

  private static final Random random = new Random();

  @Override
  public int generateRandomNumber(int origin, int bound) {
    return random.nextInt(origin, bound);
  }

}
