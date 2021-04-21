package com.tourism.tourism.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
}
