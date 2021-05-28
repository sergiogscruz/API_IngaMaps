package com.tourism.tourism.tourist;

import com.tourism.tourism.person.PersonBadRequestException;
import com.tourism.tourism.person.PersonType;
import com.tourism.tourism.personaddress.PersonAddress;
import com.tourism.tourism.personaddress.PersonAddressRepository;
import com.tourism.tourism.personaddress.PersonAddressService;
import com.tourism.tourism.photo.PhotoService;
import com.tourism.tourism.userlogin.Role;
import com.tourism.tourism.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class TouristService {
  @Autowired
  private TouristRepository touristRepository;
  @Autowired
  private UserLoginService userLoginService;
  @Autowired
  private PhotoService photoService;
  @Autowired
  private PersonAddressRepository personAddressRepository;
  @Autowired
  private PersonAddressService personAddressService;

  public Tourist saveTouristAnonymous(Tourist touristAnonymous) {
    return touristRepository.save(touristAnonymous);
  }

  public Tourist save(Tourist tourist) {
    tourist.setPersonType(PersonType.TOURIST);
    validateTourist(tourist);
    tourist.getUserLogin().setRole(Role.TOURIST);
    tourist.setUserLogin(userLoginService.save(tourist.getUserLogin()));
    if (!Objects.isNull(tourist.getPhoto())) {
      photoService.validadePhoto(tourist.getPhoto());
    }
    if (!Objects.isNull(tourist.getPersonAddress().getId())) {
      Optional<PersonAddress> personAddress = personAddressRepository.findById(tourist.getPersonAddress().getId());
      if (personAddress.isPresent()) {
        tourist.setPersonAddress(personAddress.get());
      } else {
        tourist.setPersonAddress(savePersonAddress(tourist.getPersonAddress()));
      }
    } else {
      tourist.setPersonAddress(savePersonAddress(tourist.getPersonAddress()));
    }
    return touristRepository.save(tourist);
  }

  public void validateTourist(Tourist tourist) {
    if (Objects.isNull(tourist.getName())) {
      throw new PersonBadRequestException("Tourist without name.");
    }
    if (Objects.isNull(tourist.getUserLogin())) {
      throw new PersonBadRequestException("Tourist without user.");
    }
    if (Objects.isNull(tourist.getPersonAddress())) {
      throw new PersonBadRequestException("Tourist without person address.");
    }
  }

  public PersonAddress savePersonAddress(PersonAddress personAddress) {
    personAddressService.validatePersonAddress(personAddress);
    return personAddressRepository.save(personAddress);
  }

  public Tourist getCurrentTourist() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return touristRepository.getByUserLoginId(
            userLoginService.getIdByUsername(((User) principal).getUsername())
    );
  }
}
