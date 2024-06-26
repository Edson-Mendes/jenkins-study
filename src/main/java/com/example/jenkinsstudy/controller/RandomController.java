package com.example.jenkinsstudy.controller;

import com.example.jenkinsstudy.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/random")
public class RandomController {

  private final RandomService randomService;

  @GetMapping("/number")
  public ResponseEntity<Integer> getRandomNumber(
      @RequestParam(value = "origin", required = false, defaultValue = "-2147483648") int origin,
      @RequestParam(value = "bound", required = false, defaultValue = "2147483647") int bound) {
    return ResponseEntity.ok(randomService.generateRandomNumber(origin, bound));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ProblemDetail> handleIllegalArgument(IllegalArgumentException exception) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(400);
    problemDetail.setTitle("Illegal argument exception");
    problemDetail.setDetail(exception.getMessage());

    return ResponseEntity.badRequest().body(problemDetail);
  }

}
