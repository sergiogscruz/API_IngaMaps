package com.tourism.tourism.employee;

import com.tourism.tourism.person.PersonBadRequestException;
import com.tourism.tourism.person.PersonType;
import com.tourism.tourism.photo.PhotoService;
import com.tourism.tourism.user.Role;
import com.tourism.tourism.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private PhotoService photoService;

  public Employee save(Employee employee) {
    employee.setPersonType(PersonType.EMPLOYEE);
    validateEmployee(employee);
    employee.getUserLogin().setRole(Role.EMPLOYEE);
    employee.setUserLogin(userService.save(employee.getUserLogin()));
    if (!Objects.isNull(employee.getPhoto())) {
      photoService.validadePhoto(employee.getPhoto());
    }
    return employeeRepository.save(employee);
  }

  public void validateEmployee(Employee employee) {
    if (Objects.isNull(employee.getName())) {
      throw new PersonBadRequestException("Employee without name.");
    }
    if (Objects.isNull(employee.getUserLogin())) {
      throw new PersonBadRequestException("Employee without user.");
    }
  }
}
