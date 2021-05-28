package com.tourism.tourism.seed;

import com.tourism.tourism.employee.Employee;
import com.tourism.tourism.employee.EmployeeService;
import com.tourism.tourism.person.PersonType;
import com.tourism.tourism.tourist.Tourist;
import com.tourism.tourism.tourist.TouristService;
import com.tourism.tourism.user.Role;
import com.tourism.tourism.user.UserLogin;
import com.tourism.tourism.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SeedService {
    @Autowired
    private TouristService touristService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    public void runAll() {
        runTouristAnonymous();
        runEmployeeAdmin();
    }

    public void runTouristAnonymous() {
        Long userLoginIdExistent = userService.getIdByUsername("anonimo");
        if (Objects.isNull(userLoginIdExistent)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername("anonimo");
            userLogin.setPassword("ingamaps");
            userLogin.setName("Anônimo");
            userLogin.setRole(Role.TOURIST_ANONYMOUS);

            Tourist touristAnonymous = new Tourist();
            touristAnonymous.setName("Anônimo");
            touristAnonymous.setPersonType(PersonType.TOURIST_ANONYMOUS);
            touristAnonymous.setUserLogin(userService.save(userLogin));

            touristService.saveTouristAnonymous(touristAnonymous);
        }
    }

    public void runEmployeeAdmin() {
        Long userLoginIdExistent = userService.getIdByUsername("admin");
        if (Objects.isNull(userLoginIdExistent)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername("admin");
            userLogin.setPassword("123456");
            userLogin.setName("Admin");
            userLogin.setRole(Role.EMPLOYEE);

            Employee employeeAdmin = new Employee();
            employeeAdmin.setName("Admin");
            employeeAdmin.setPersonType(PersonType.EMPLOYEE);
            employeeAdmin.setUserLogin(userService.save(userLogin));

            employeeService.saveEmployeeAdmin(employeeAdmin);
        }
    }
}
