package com.example.jenkinsstudy.service.impl;

import com.example.jenkinsstudy.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class RandomServiceImpl implements RandomService {

  private final Random random;

  @Override
  public int generateRandomNumber(int origin, int bound) {
    return random.nextInt(origin, bound);
  }

}
