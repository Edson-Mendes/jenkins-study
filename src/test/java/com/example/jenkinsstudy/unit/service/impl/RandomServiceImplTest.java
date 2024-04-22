package com.example.jenkinsstudy.unit.service.impl;

import com.example.jenkinsstudy.service.impl.RandomServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Unit tests for RandomServiceImpl")
class RandomServiceImplTest {

  @InjectMocks
  private RandomServiceImpl randomService;
  @Mock
  private Random randomMock;

  @Test
  @DisplayName("generateRandomNumber must return a integer between 1 and 10 when origin is 1 and bound is 10")
  void generateRandomNumber_MustReturnAIntegerBetween1And10_WhenOriginIs1AndBoundIs10() {
    when(randomMock.nextInt(1, 10)).thenReturn(8);
    int origin = 1;
    int bound = 10;
    int actualInteger = randomService.generateRandomNumber(origin, bound);

    assertThat(actualInteger).isBetween(1, 10);
  }

  @Test
  @DisplayName("generateRandomNumber must throw IllegalArgumentException when origin is bigger than bound")
  void generateRandomNumber_MustThrowIllegalArgumentException_WhenOriginIsBiggerThanBound() {
    when(randomMock.nextInt(10, 1))
        .thenThrow(new IllegalArgumentException("bound must be greater than origin"));
    int origin = 10;
    int bound = 1;

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> randomService.generateRandomNumber(origin, bound))
        .withMessage("bound must be greater than origin");
  }

}