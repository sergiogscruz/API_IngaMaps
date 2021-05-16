package com.tourism.tourism.travel;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.local.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
@Transactional
public class TravelService {
  @Autowired
  private TravelRepository travelRepository;
  @Autowired
  private LocalService localService;

  public Travel save(Travel travel) {
    this.validateTravel(travel);
    return travelRepository.save(travel);
  }

  public void validateTravel(Travel travel) {
    if (Objects.isNull(travel.getReason())) {
      throw new TravelBadRequestException("Travel without reason.");
    }
    if (Objects.isNull(travel.getDate())) {
      throw new TravelBadRequestException("Travel without date.");
    }
    if (travel.getDate().before(new Date())) {
      throw new TravelBadRequestException("The date must be after the current date.");
    }
    if (Objects.isNull(travel.getTourist())) {
      throw new TravelBadRequestException("Travel without tourist.");
    }
    if (Objects.isNull(travel.getLocal()) || Objects.isNull(travel.getLocal().getId())) {
      throw new TravelBadRequestException("Travel without local.");
    }
    Local local = localService.getById(travel.getLocal().getId());
    if (Objects.isNull(local)) {
      throw new TravelBadRequestException("Local not found.");
    }
  }
}
