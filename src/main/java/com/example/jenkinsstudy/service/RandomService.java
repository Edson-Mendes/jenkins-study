package com.example.jenkinsstudy.service;

/**
 * Interface service.
 */
public interface RandomService {

  /**
   * Gera um inteiro no intervalo {@code [origin, bound]}.
   *
   * @param origin valor inicial do intervalo para gerar um inteiro.
   * @param bound  valor final do intervalo para gerar um inteiro.
   * @return inteiro no intervalo {@code [origin, bound]}
   * @throws IllegalArgumentException caso {@code origin} seja menor que {@code bound}.
   */
  int generateRandomNumber(int origin, int bound);

}
