package com.tourism.tourism.person;

import com.tourism.tourism.person.dto.PersonChangePhotoDTO;
import com.tourism.tourism.photo.Photo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  public Person changePhoto(PersonChangePhotoDTO personChangePhotoDTO) {
    validatePersonChangePhoto(personChangePhotoDTO);
    Person person = personRepository.getOne(personChangePhotoDTO.getPersonId());
    if (Objects.isNull(person.getPhoto())) {
      Photo photo = new Photo();
      photo.setBase64(personChangePhotoDTO.getBase64());
      person.setPhoto(photo);
    } else {
      person.getPhoto().setBase64(personChangePhotoDTO.getBase64());
    }
    return personRepository.save(person);
  }

  public void validatePersonChangePhoto(PersonChangePhotoDTO personChangePhotoDTO) {
    if (Objects.isNull(personChangePhotoDTO.getPersonId())) {
      throw new PersonBadRequestException("Without person identifier.");
    }
    if (Objects.isNull(personChangePhotoDTO.getBase64()) || personChangePhotoDTO.getBase64().isBlank()) {
      throw new PersonBadRequestException("Without photo base64.");
    }
  }
}
