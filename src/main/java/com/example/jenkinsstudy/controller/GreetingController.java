package com.example.jenkinsstudy.controller;

import com.example.jenkinsstudy.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/greeting")
public class GreetingController {

  private final GreetingService greetingService;

  @GetMapping
  public ResponseEntity<String> getGreeting(@RequestParam(name = "name", required = false) String name) {
    return ResponseEntity.ok(greetingService.getGreeting(name));
  }

}
