package com.example.jenkinsstudy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/random")
public class RandomController {

  @GetMapping("/number")
  public ResponseEntity<Integer> getRandomNumber() {
    Random random = new Random();
    int randomInteger = random.nextInt();

    return ResponseEntity.ok(randomInteger);
  }

}
