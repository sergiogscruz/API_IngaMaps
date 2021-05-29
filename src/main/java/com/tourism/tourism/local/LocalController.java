package com.tourism.tourism.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @GetMapping
  public Page<Local> get(Pageable page, @RequestParam(name = "localName", required = false) String localName, @RequestParam(name = "localCategory", required = false) LocalCategory localCategory) {
    return localService.getAll(page, localName, localCategory);
  }

}
