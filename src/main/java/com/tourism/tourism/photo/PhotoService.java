package com.tourism.tourism.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhotoService {
  @Autowired
  private PhotoRepository photoRepository;
}
