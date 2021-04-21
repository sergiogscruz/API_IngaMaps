package com.tourism.tourism.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TravelService {
  @Autowired
  private TravelRepository travelRepository;
}
