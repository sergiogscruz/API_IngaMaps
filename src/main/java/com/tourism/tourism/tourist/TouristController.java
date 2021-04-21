package com.tourism.tourism.tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
  @Autowired
  private TouristService touristService;
}
