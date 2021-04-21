package com.tourism.tourism.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {
  @Autowired
  private EventService eventService;

  @PostMapping
  public Event save(@RequestBody Event event) {
    return eventService.save(event);
  }

  @GetMapping("/{id}")
  public Event getById(@PathVariable("id") Long id) {
    return eventService.getById(id);
  }
}
