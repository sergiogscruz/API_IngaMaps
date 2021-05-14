package com.tourism.tourism.personaddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class PersonAddressService {
  @Autowired
  private PersonAddressRepository personAddressRepository;

  public void validatePersonAddress(PersonAddress personAddress) {
    if (Objects.isNull(personAddress.getCountry())) {
      throw new PersonAddressBadRequestException("Person address without country.");
    }
    if (Objects.isNull(personAddress.getState())) {
      throw new PersonAddressBadRequestException("Person address without state.");
    }
    if (Objects.isNull(personAddress.getCity())) {
      throw new PersonAddressBadRequestException("Person address without city.");
    }
  }
}
