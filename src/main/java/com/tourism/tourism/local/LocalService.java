package com.tourism.tourism.local;

import com.tourism.tourism.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class LocalService {
  @Autowired
  private LocalRepository localRepository;
  @Autowired
  private AddressService addressService;

  public Local save(Local local) {
    this.validateLocal(local);
    addressService.validateAddress(local.getAddress());
    return localRepository.save(local);
  }

  public void validateLocal(Local local) {
    if (Objects.isNull(local.getName())) {
      throw new LocalBadRequestException("Local without name.");
    }
    if (Objects.isNull(local.getDescription())) {
      throw new LocalBadRequestException("Local without description.");
    }
    if (Objects.isNull(local.getCategory())) {
      throw new LocalBadRequestException("Local without category.");
    }
    if (Objects.isNull(local.getAddress())) {
      throw new LocalBadRequestException("Local without address.");
    }
  }

  public Local getById(Long id) {
    return localRepository.findById(id).orElse(null);
  }
}
