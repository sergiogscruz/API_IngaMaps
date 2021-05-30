package com.tourism.tourism.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
  @Autowired
  private ContactService contactService;

  @PostMapping
  public Contact save(@RequestBody Contact contact) {
    return contactService.save(contact);
  }

  @GetMapping
  public Page<Contact> getContactsByNameAndCategory(Pageable pageable,
                                                    @RequestParam(value = "name", defaultValue = "") String name,
                                                    @RequestParam(value = "category", defaultValue = "") String category) {
    return contactService.getContactsByNameAndCategory(pageable, name, category);
  }
}
