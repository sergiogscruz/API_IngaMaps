package com.tourism.tourism.event;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.local.LocalRepository;
import com.tourism.tourism.photo.Photo;
import com.tourism.tourism.photo.PhotoRepository;
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
  private PhotoRepository photoRepository;
  @Autowired
  private LocalRepository localRepository;

  public Event save(Event event) {
    if(!Objects.isNull(event.getLocal())) {
      Optional<Local> local = localRepository.findById(event.getLocal().getId());
      if(!local.isPresent()) {
        throw new IllegalArgumentException("Local not found.");
      }
      event.setLocal(local.get());
    }

    if(!Objects.isNull(event.getPhoto())) {
      Photo photo = photoRepository.save(event.getPhoto());
      event.setPhoto(photo);
    }
    return eventRepository.save(event);
  }

  public Event getById(Long id) {
    return eventRepository.findById(id).orElse(null);
  }
}
