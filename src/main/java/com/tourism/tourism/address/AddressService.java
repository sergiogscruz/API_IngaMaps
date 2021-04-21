package com.tourism.tourism.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;
}
