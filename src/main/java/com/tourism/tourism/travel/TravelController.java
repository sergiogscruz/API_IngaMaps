package com.tourism.tourism.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel")
public class TravelController {
  @Autowired
  private TravelService travelService;

  @PostMapping
  public Travel save(@RequestBody Travel travel) {
    return travelService.save(travel);
  }

  @PostMapping(path = "/comment/{id}")
  public void saveFeedback(@PathVariable Long id, @RequestBody String comment) {
    travelService.saveComment(id, comment);
  }
}
