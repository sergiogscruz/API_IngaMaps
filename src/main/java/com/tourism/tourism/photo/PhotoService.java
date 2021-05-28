package com.tourism.tourism.photo;

import com.tourism.tourism.photo.exceptions.PhotoBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class PhotoService {
  @Autowired
  private PhotoRepository photoRepository;

  public void validadePhoto(Photo photo) {
    if (Objects.isNull(photo.getBase64())) {
      throw new PhotoBadRequestException("Photo without base64.");
    }
  }
}
