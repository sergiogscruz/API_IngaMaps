package com.tourism.tourism.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
  @Autowired
  private ContactService contactService;

  @PostMapping
  public Contact save(@RequestBody Contact contact) {
    return contactService.save(contact);
  }
}
