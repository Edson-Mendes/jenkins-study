package com.example.jenkinsstudy.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayName("Unit tests for RandomServiceImpl")
class RandomServiceImplTest {

  @InjectMocks
  private RandomServiceImpl randomService;

  @Test
  @DisplayName("generateRandomNumber must return a integer between 1 and 10 when origin is 1 and bound is 10")
  void generateRandomNumber_MustReturnAIntegerBetween1And10_WhenOriginIs1AndBoundIs10() {
    int origin = 1;
    int bound = 10;
    int actualInteger = randomService.generateRandomNumber(origin, bound);

    assertThat(actualInteger).isBetween(1, 10);
  }

  @Test
  @DisplayName("generateRandomNumber must throw IllegalArgumentException when origin is bigger than bound")
  void generateRandomNumber_MustThrowIllegalArgumentException_WhenOriginIsBiggerThanBound() {
    int origin = 10;
    int bound = 1;

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> randomService.generateRandomNumber(origin, bound))
        .withMessage("bound must be greater than origin");
  }

}