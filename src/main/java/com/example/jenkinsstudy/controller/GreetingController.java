package com.example.jenkinsstudy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @GetMapping
  public ResponseEntity<String> getGreeting(@RequestParam(name = "name", required = false) String name) {
    String greetingTemplate = "Hello %s!";
    String value = name != null ? name : "World";
    return ResponseEntity.ok(greetingTemplate.formatted(value));
  }

}
