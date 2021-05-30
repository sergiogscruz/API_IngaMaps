package com.tourism.tourism.local;

import com.tourism.tourism.address.AddressService;
import com.tourism.tourism.local.exceptions.LocalBadRequestException;
import com.tourism.tourism.photo.Photo;
import com.tourism.tourism.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tourism.tourism.local.enums.LocalCategory;

import java.util.Objects;

@Service
@Transactional
public class LocalService {
  @Autowired
  private LocalRepository localRepository;
  @Autowired
  private AddressService addressService;
  @Autowired
  private PhotoService photoService;

  public Local save(Local local) {
    this.validateLocal(local);
    addressService.validateAddress(local.getAddress());
    if (!Objects.isNull(local.getPhotos()) && local.getPhotos().size() > 0) {
      for (Photo photo:local.getPhotos()) {
        photoService.validadePhoto(photo);
      }
    }
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

  public Local getAndValidateById(Long id) {
    Local local = getById(id);
    if (Objects.isNull(local)) {
      throw new LocalBadRequestException("Local not found.");
    }
    return local;
  }

  public Page<Local> getAll(Pageable page, String localName, LocalCategory localCategory) {
    if ((localName == null || localName.trim().length() == 0) && localCategory == null) {
      return localRepository.findAll(page);            
    }

    if (localCategory == null) {
      return localRepository.findByNameLike(page, "%" + localName + "%");
    }

    return localRepository.findByNameLikeAndCategory(page, "%" + localName + "%", localCategory);

  }

}
