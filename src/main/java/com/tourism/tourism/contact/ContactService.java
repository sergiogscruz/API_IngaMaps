package com.tourism.tourism.contact;

import com.tourism.tourism.contact.exceptions.ContactBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ContactService {
  @Autowired
  private ContactRepository contactRepository;

  public Contact save(Contact contact) {
    this.validateContact(contact);
    return contactRepository.save(contact);
  }

  public void validateContact(Contact contact) {
    if (Objects.isNull(contact.getName())) {
      throw new ContactBadRequestException("Contact without name.");
    }
    if (Objects.isNull(contact.getDescription())) {
      throw new ContactBadRequestException("Contact without description.");
    }
    if (Objects.isNull(contact.getEmail())) {
      throw new ContactBadRequestException("Contact without email.");
    }
    if (Objects.isNull(contact.getPhoneNumber())) {
      throw new ContactBadRequestException("Contact without phone number.");
    }
    if (Objects.isNull(contact.getCategory())) {
      throw new ContactBadRequestException("Contact without category.");
    }
  }
}
