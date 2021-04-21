package com.tourism.tourism.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
  @Autowired
  private PhotoService photoService;
}
