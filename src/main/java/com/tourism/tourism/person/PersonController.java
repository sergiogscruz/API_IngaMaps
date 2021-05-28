package com.tourism.tourism.person;

import com.tourism.tourism.person.dtos.PersonChangePhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {
  @Autowired
  private PersonService personService;

  @PostMapping(path = "change-photo")
  public Person changePhoto(@RequestBody PersonChangePhotoDTO personChangePhotoDTO) {
    return personService.changePhoto(personChangePhotoDTO);
  }
}
