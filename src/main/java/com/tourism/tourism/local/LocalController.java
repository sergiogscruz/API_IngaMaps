package com.tourism.tourism.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/local")
public class LocalController {
  @Autowired
  private LocalService localService;

  @PostMapping
  public Local save(@RequestBody Local local) {
    return localService.save(local);
  }

  @GetMapping("/{id}")
  public Local getById(@PathVariable("id") Long id) {
    return localService.getById(id);
  }
}
