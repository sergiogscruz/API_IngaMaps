package com.tourism.tourism.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;

  public void validateAddress(Address address) {
    if (Objects.isNull(address.getCountry())) {
      throw new AddressBadRequestException("Address without country.");
    }
    if (Objects.isNull(address.getState())) {
      throw new AddressBadRequestException("Address without state.");
    }
    if (Objects.isNull(address.getCity())) {
      throw new AddressBadRequestException("Address without city.");
    }
    if (Objects.isNull(address.getNeighborhood())) {
      throw new AddressBadRequestException("Address without neighborhood.");
    }
    if (Objects.isNull(address.getStreet())) {
      throw new AddressBadRequestException("Address without street.");
    }
    if (Objects.isNull(address.getNumber())) {
      throw new AddressBadRequestException("Address without number.");
    }
  }
}
