package com.tourism.tourism.travel;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.local.LocalService;
import com.tourism.tourism.tourist.TouristService;
import com.tourism.tourism.travel.exceptions.TravelBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class TravelService {
  @Autowired
  private TravelRepository travelRepository;
  @Autowired
  private LocalService localService;
  @Autowired
  private TouristService touristService;

  public Travel save(Travel travel) {
    travel.setTourist(touristService.getCurrentTourist());
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

  public void saveComment(Long id, String comment) {
    Travel travel = this.validateTravelToComment(id);
    travel.setComment(comment);
    travelRepository.save(travel);
  }

  public Travel validateTravelToComment(Long id) {
    Optional<Travel> travel = travelRepository.findById(id);
    if (!travel.isPresent()) {
      throw new TravelBadRequestException("Travel not found.");
    }
    if (Objects.nonNull(travel.get().getComment())) {
      throw new TravelBadRequestException("Travel already commented.");
    }
    if (travel.get().getDate().after(new Date())) {
      throw new TravelBadRequestException("Travel not done yet.");
    }
    return travel.get();
  }
}
