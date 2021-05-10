package com.tourism.tourism.tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
  @Autowired
  private TouristService touristService;

  @PostMapping
  public Tourist save(@RequestBody Tourist tourist) {
    return touristService.save(tourist);
  }
}
