package com.tourism.tourism.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel")
public class TravelController {
  @Autowired
  private TravelService travelService;

  @PostMapping
  public Travel save(@RequestBody Travel travel) {
    return travelService.save(travel);
  }
}
