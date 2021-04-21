package com.tourism.tourism.local;

import com.tourism.tourism.address.Address;
import com.tourism.tourism.address.AddressRepository;
import com.tourism.tourism.photo.Photo;
import com.tourism.tourism.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class LocalService {
  @Autowired
  private LocalRepository localRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private PhotoRepository photoRepository;
  
  public Local save(Local local) {
    if (!Objects.isNull(local.getAddress())) {
      Address address = addressRepository.save(local.getAddress());
      local.setAddress(address);
    }
    if (!Objects.isNull(local.getPhotos()) && local.getPhotos().size() > 0) {
      List<Photo> photos = new ArrayList<>();
      local.getPhotos().forEach(photo -> photos.add(photoRepository.save(photo)));
      local.setPhotos(photos);
    }
    return localRepository.save(local);
  }

  public Local getById(Long id) {
    return localRepository.findById(id).orElse(null);
  }
}
