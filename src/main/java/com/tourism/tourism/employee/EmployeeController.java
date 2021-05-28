package com.tourism.tourism.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public Employee save(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }
}
