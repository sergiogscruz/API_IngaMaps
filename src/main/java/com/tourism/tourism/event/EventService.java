package com.tourism.tourism.event;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.local.LocalRepository;
import com.tourism.tourism.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class EventService {
  @Autowired
  private EventRepository eventRepository;
  @Autowired
  private LocalRepository localRepository;
  @Autowired
  private PhotoService photoService;

  public Event save(Event event) {
    this.validateEvent(event);
    if (!Objects.isNull(event.getPhoto())) {
      photoService.validadePhoto(event.getPhoto());
    }
    return eventRepository.save(event);
  }

  public void validateEvent(Event event) {
    if (Objects.isNull(event.getName())) {
      throw new EventBadRequestException("Event without name.");
    }
    if (Objects.isNull(event.getDescription())) {
      throw new EventBadRequestException("Event without description.");
    }
    if (Objects.isNull(event.getWayParticipate())) {
      throw new EventBadRequestException("Event without way participate.");
    }
    if (Objects.isNull(event.getStartDate())) {
      throw new EventBadRequestException("Event without start date.");
    }
    if (Objects.isNull(event.getEndDate())) {
      throw new EventBadRequestException("Event without end date.");
    }
    if (Objects.isNull(event.getLocal())) {
      throw new EventBadRequestException("Event without local.");
    }
    Optional<Local> local = localRepository.findById(event.getLocal().getId());
    if (!local.isPresent()) {
      throw new EventBadRequestException("Local not found.");
    }
  }

  public Event getById(Long id) {
    return eventRepository.findById(id).orElse(null);
  }
}
